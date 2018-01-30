package cn.tarena.gm.controller;

import cn.tarena.gm.pojo.Order;
import cn.tarena.gm.pojo.OrderItem;
import cn.tarena.gm.pojo.Product;
import cn.tarena.gm.pojo.User;
import cn.tarena.gm.service.OrderService;
import cn.tarena.gm.service.ProductService;
import cn.tarena.gm.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

@Controller
public class POIExcelController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService prodService;

	@RequestMapping("/createxcel")
	public String getOrderExcel(String orderId, HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, IOException {

		HSSFWorkbook wb = new HSSFWorkbook();
		CreationHelper createHelper = wb.getCreationHelper();

		Order order = orderService.findOrderById(orderId);
		List<OrderItem> orderItems = orderService.findItemByOrderId(orderId);
		Integer userId=order.getUser_id();
		System.out.println(order.getUser_id());
		User user = userService.findUserById(userId);
		Map<String, CellStyle> styles = createStyles(wb);

		Sheet sheet = wb.createSheet("sheet1");
		sheet.setPrintGridlines(false);
		sheet.setDisplayGridlines(false);

		PrintSetup printSetup = sheet.getPrintSetup();
		printSetup.setLandscape(true);
		sheet.setFitToPage(true);
		sheet.setHorizontallyCenter(true);

		sheet.setColumnWidth(0, 3 * 256);
		sheet.setColumnWidth(1, 3 * 256);
		sheet.setColumnWidth(2, 11 * 256);
		sheet.setColumnWidth(3, 14 * 256);
		sheet.setColumnWidth(4, 14 * 256);
		sheet.setColumnWidth(5, 14 * 256);
		sheet.setColumnWidth(6, 14 * 256);

		Row titleRow = sheet.createRow(0);
		titleRow.setHeightInPoints(35);
		for (int i = 1; i <= 7; i++) {
			titleRow.createCell(i).setCellStyle(styles.get("title"));
		}
		Cell titleCell = titleRow.getCell(2);
		titleCell.setCellValue("GuitarMall电子收据");
		sheet.addMergedRegion(CellRangeAddress.valueOf("$C$1:$H$1"));

		Row row = sheet.createRow(2);
		Cell cell = row.createCell(4);
		cell.setCellValue("详情");
		cell.setCellStyle(styles.get("item_right"));

		row = sheet.createRow(3);
		cell = row.createCell(2);
		cell.setCellValue("订单号");
		cell.setCellStyle(styles.get("item_left"));
		cell = row.createCell(5);
		cell.setCellStyle(styles.get("item_right"));
		cell.setCellStyle(styles.get("input_ii"));
		cell.setCellValue(order.getId());
		cell.setAsActiveCell();

		row = sheet.createRow(4);
		cell = row.createCell(2);
		cell.setCellValue("订单金额");
		cell.setCellStyle(styles.get("item_left"));
		cell = row.createCell(4);
		cell.setCellValue(order.getMoney());
		cell.setCellStyle(styles.get("input_ii"));

		row = sheet.createRow(5);
		cell = row.createCell(2);
		cell.setCellValue("收货地址");
		cell.setCellStyle(styles.get("item_left"));
		cell = row.createCell(4);
		cell.setCellValue(order.getReceiverinfo());
		cell.setCellStyle(styles.get("input_ii"));

		row = sheet.createRow(6);
		cell = row.createCell(2);
		cell.setCellValue("订单时间");
		cell.setCellStyle(styles.get("item_left"));
		cell = row.createCell(4);
		cell.setCellValue(order.getOrdertime());
		cell.setCellStyle(styles.get("input_d"));

		row = sheet.createRow(8);
		cell = row.createCell(2);
		cell.setCellValue("用户名");
		cell.setCellStyle(styles.get("item_left"));
		cell = row.createCell(4);
		cell.setCellValue(user.getUsername());
		// cell.setCellFormula("IF(Values_Entered,Monthly_Payment,\"\")");
		cell.setCellStyle(styles.get("formula_$"));
		row = sheet.createRow(9);
		int i = 10;
		for (OrderItem item : orderItems) {
			Product prod = prodService.findProdById(item.getProduct_id());
			row = sheet.createRow(i);
			cell = row.createCell(2);
			cell.setCellValue("商品名称");
			cell.setCellStyle(styles.get("item_left"));
			cell = row.createCell(4);
			// cell.setCellFormula("IF(Values_Entered,Loan_Years*12,\"\")");
			cell.setCellValue(prod.getName());
			cell.setCellStyle(styles.get("formula_i"));
			i++;

			row = sheet.createRow(i);
			cell = row.createCell(2);
			cell.setCellValue("商品单价");
			cell.setCellStyle(styles.get("item_left"));
			cell = row.createCell(4);
			// cell.setCellFormula("IF(Values_Entered,Loan_Years*12,\"\")");
			cell.setCellValue(prod.getPrice());
			cell.setCellStyle(styles.get("formula_i"));

			i++;

			row = sheet.createRow(i);
			cell = row.createCell(2);
			cell.setCellValue("购买数量");
			cell.setCellStyle(styles.get("item_left"));
			cell = row.createCell(4);
			// cell.setCellFormula("IF(Values_Entered,Loan_Years*12,\"\")");
			cell.setCellValue(item.getBuynum());
			cell.setCellStyle(styles.get("formula_i"));

			i++;
			row = sheet.createRow(i);
			i++;
		}
		

		// Write the output to a file
		// String path = "/WEB-INF/excel/";
		String filename =UUID.randomUUID().toString().substring(10) + new Date().getTime() + ".xls";
			
		// 3、告知浏览器以附件下载的方式处理
		response.setHeader("Content-Disposition", "attachment;filename=" + filename);

		OutputStream fi=response.getOutputStream();
		wb.write(fi);
		fi.close();

		return orderId;

	}

	private static Map<String, CellStyle> createStyles(Workbook wb) {
		Map<String, CellStyle> styles = new HashMap<String, CellStyle>();

		CellStyle style;
		Font titleFont = wb.createFont();
		titleFont.setFontHeightInPoints((short) 14);
		titleFont.setFontName("Trebuchet MS");
		style = wb.createCellStyle();
		style.setFont(titleFont);
		style.setBorderBottom(BorderStyle.DOTTED);
		style.setBottomBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		styles.put("title", style);

		Font itemFont = wb.createFont();
		itemFont.setFontHeightInPoints((short) 9);
		itemFont.setFontName("Trebuchet MS");
		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.LEFT);
		style.setFont(itemFont);
		styles.put("item_left", style);

		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.RIGHT);
		style.setFont(itemFont);
		styles.put("item_right", style);

		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.RIGHT);
		style.setFont(itemFont);
		style.setBorderRight(BorderStyle.DOTTED);
		style.setRightBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderBottom(BorderStyle.DOTTED);
		style.setBottomBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderLeft(BorderStyle.DOTTED);
		style.setLeftBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderTop(BorderStyle.DOTTED);
		style.setTopBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setDataFormat(wb.createDataFormat().getFormat("_($* #,##0.00_);_($* (#,##0.00);_($* \"-\"??_);_(@_)"));
		styles.put("input_$", style);

		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.RIGHT);
		style.setFont(itemFont);
		style.setBorderRight(BorderStyle.DOTTED);
		style.setRightBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderBottom(BorderStyle.DOTTED);
		style.setBottomBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderLeft(BorderStyle.DOTTED);
		style.setLeftBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderTop(BorderStyle.DOTTED);
		style.setTopBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setDataFormat(wb.createDataFormat().getFormat("0.000%"));
		styles.put("input_%", style);

		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.RIGHT);
		style.setFont(itemFont);
		style.setBorderRight(BorderStyle.DOTTED);
		style.setRightBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderBottom(BorderStyle.DOTTED);
		style.setBottomBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderLeft(BorderStyle.DOTTED);
		style.setLeftBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderTop(BorderStyle.DOTTED);
		style.setTopBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setDataFormat(wb.createDataFormat().getFormat("0"));
		styles.put("input_i", style);

		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setFont(itemFont);
		style.setDataFormat(wb.createDataFormat().getFormat("m/d/yy"));
		styles.put("input_d", style);
		
		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.RIGHT);
		style.setFont(itemFont);
		style.setDataFormat(wb.createDataFormat().getFormat("0"));
		styles.put("input_ii", style);

		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.RIGHT);
		style.setFont(itemFont);
		style.setBorderRight(BorderStyle.DOTTED);
		style.setRightBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderBottom(BorderStyle.DOTTED);
		style.setBottomBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderLeft(BorderStyle.DOTTED);
		style.setLeftBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderTop(BorderStyle.DOTTED);
		style.setTopBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setDataFormat(wb.createDataFormat().getFormat("$##,##0.00"));
		style.setBorderBottom(BorderStyle.DOTTED);
		style.setBottomBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		styles.put("formula_$", style);

		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.RIGHT);
		style.setFont(itemFont);
		style.setBorderRight(BorderStyle.DOTTED);
		style.setRightBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderBottom(BorderStyle.DOTTED);
		style.setBottomBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderLeft(BorderStyle.DOTTED);
		style.setLeftBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setBorderTop(BorderStyle.DOTTED);
		style.setTopBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setDataFormat(wb.createDataFormat().getFormat("0"));
		style.setBorderBottom(BorderStyle.DOTTED);
		style.setBottomBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		styles.put("formula_i", style);

		return styles;
	}

	public static void createNames(Workbook wb) {
		Name name;

		name = wb.createName();
		name.setNameName("Interest_Rate");
		name.setRefersToFormula("'Loan Calculator'!$E$5");

		name = wb.createName();
		name.setNameName("Loan_Amount");
		name.setRefersToFormula("'Loan Calculator'!$E$4");

		name = wb.createName();
		name.setNameName("Loan_Start");
		name.setRefersToFormula("'Loan Calculator'!$E$7");

		name = wb.createName();
		name.setNameName("Loan_Years");
		name.setRefersToFormula("'Loan Calculator'!$E$6");

		name = wb.createName();
		name.setNameName("Number_of_Payments");
		name.setRefersToFormula("'Loan Calculator'!$E$10");

		name = wb.createName();
		name.setNameName("Monthly_Payment");
		name.setRefersToFormula("-PMT(Interest_Rate/12,Number_of_Payments,Loan_Amount)");

		name = wb.createName();
		name.setNameName("Total_Cost");
		name.setRefersToFormula("'Loan Calculator'!$E$12");

		name = wb.createName();
		name.setNameName("Total_Interest");
		name.setRefersToFormula("'Loan Calculator'!$E$11");

		name = wb.createName();
		name.setNameName("Values_Entered");
		name.setRefersToFormula("IF(Loan_Amount*Interest_Rate*Loan_Years*Loan_Start>0,1,0)");
	}
}
