package com.xiaobaichuan.zhixuan.backstage.entity;

import com.xiaobaichuan.zhixuan.homepage.entity.Positioninfo;
import com.xiaobaichuan.zhixuan.homepage.service.IPositioninfoService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {


    // 总行数
    private int totalRows = 0;
    // 总条数
    private int totalCells = 0;
    // 错误信息接收器
    private String errorMsg;

    // 构造方法
    public ReadExcel() {
    }

    // 获取总行数
    public int getTotalRows() {
        return totalRows;
    }

    // 获取总列数
    public int getTotalCells() {
        return totalCells;
    }

    // 获取错误信息
    public String getErrorInfo() {
        return errorMsg;
    }

    public List<Positioninfo> getExcelInfo(MultipartFile mFile) {
        List<Positioninfo> positioninfoList = new ArrayList<>();
        String fileName = mFile.getOriginalFilename();// 获取文件名
        try {
            if (!validateExcel(fileName)) {// 验证文件名是否合格
                return null;
            }
            boolean isExcel2003 = true;// 根据文件名判断文件是2003版本还是2007版本
            if (isExcel2007(fileName)) {
                isExcel2003 = false;
            }
            System.out.println("isExcel2003 = "+isExcel2003);
            System.out.println("进入createExcel");
            positioninfoList = createExcel(mFile.getInputStream(), isExcel2003);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return positioninfoList;
    }


    public List<Positioninfo> createExcel(InputStream is, boolean isExcel2003) {
        List<Positioninfo> positioninfoList = new ArrayList<>();
        try {
            Workbook wb = null;
            if (isExcel2003) {// 当excel是2003时,创建excel2003
                System.out.println("当excel是2003时,创建excel2003");
                wb = new HSSFWorkbook(is);
            } else {// 当excel是2007时,创建excel2007
                System.out.println("当excel是2007时,创建excel2007");
                wb = new XSSFWorkbook(is);
            }
            System.out.println("进入readExcelValue");
            positioninfoList = readExcelValue(wb);// 读取Excel里面客户的信息
        } catch (IOException e) {
            e.printStackTrace();
        }
        return positioninfoList;
    }


    private List<Positioninfo> readExcelValue(Workbook wb) {
        System.out.println("开始读取excel");
        // 得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        // 得到Excel的行数
        //this.totalRows = sheet.getPhysicalNumberOfRows();
        this.totalRows = sheet.getLastRowNum();
        System.out.println("得到Excel的行数 = "+totalRows);
        // 得到Excel的列数(前提是有行数)
        if (totalRows > 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println("得到Excel的列数(前提是有行数) = "+totalCells);
        }
        List<Positioninfo> positioninfoList = new ArrayList<Positioninfo>();
        // 循环Excel行数
        for (int r = 0; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            Positioninfo positioninfo = new Positioninfo();
            // 循环Excel的列
            for (int c = 0; c < this.totalCells; c++){
                Cell cell = row.getCell(c);
                if (null != cell){
                    if(c == 0){
                        //第一列
                        if(cell.getStringCellValue()!=""){
                            positioninfo.setSearch(cell.getStringCellValue());
                        }
                    }else if (c==1){
                        //第二列
                        if(cell.getStringCellValue()!=""){
                            positioninfo.setPosition(cell.getStringCellValue());
                        }
                    }else if (c==2){
                        //第三列
                        if(cell.getStringCellValue()!=""){
                            positioninfo.setTime(cell.getStringCellValue());
                        }
                    } else if (c==3){
                        //第四列
                        if(cell.getStringCellValue()!=""){
                            positioninfo.setAcademic(cell.getStringCellValue());
                        }
                    }else if (c==4){
                        //第五列
                        if(cell.getStringCellValue()!=""){
                            positioninfo.setMajor(cell.getStringCellValue());
                        }
                    }else if (c==5){
                        //第六列
                        if(cell.getStringCellValue()!=""){
                            positioninfo.setOfficehour(cell.getStringCellValue());
                        }
                    }else if (c==6){
                        //第七列
                        if(cell.getStringCellValue()!=""){
                            positioninfo.setSalary(cell.getStringCellValue());
                        }
                    }else if (c==7){
                        //第八列
                        if(cell.getStringCellValue()!=""){
                            positioninfo.setCompany(cell.getStringCellValue());
                        }
                    }else if (c==8){
                        //第九列
                        if(cell.getStringCellValue()!=""){
                            positioninfo.setIntroduction(cell.getStringCellValue());
                        }
                    }else if (c==9){
                        //第十列
                        if(cell.getStringCellValue()!=""){
                            positioninfo.setRelativeinfo(cell.getStringCellValue());
                        }
                    }else if (c==10){
                        //第十一列
                        if(cell.getStringCellValue()!=""){
                            positioninfo.setDetailedinfo(cell.getStringCellValue());
                        }
                    }else if (c==11){
                        //第十二列
                        if(cell.getStringCellValue()!=""){
                            positioninfo.setApplication(cell.getStringCellValue());
                        }
                    }
                }
            }
            /*
            User user = new User();
            // 循环Excel的列

            for (int c = 0; c < this.totalCells; c++) {
                Cell cell = row.getCell(c);
                if (null != cell) {
                    if (c == 0) {
                        // 如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                            String name = String.valueOf(cell.getNumericCellValue());
                            user.setName(name.substring(0, name.length() - 2 > 0 ? name.length() - 2 : 1));// 名称
                        } else {
                            user.setName(cell.getStringCellValue());// 名称
                        }
                    } else if (c == 1) {
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                            String sex = String.valueOf(cell.getNumericCellValue());
                            user.setSex(sex.substring(0, sex.length() - 2 > 0 ? sex.length() - 2 : 1));// 性别
                        } else {
                            user.setSex(cell.getStringCellValue());// 性别
                        }
                    } else if (c == 2) {
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                            String age = String.valueOf(cell.getNumericCellValue());
                            user.setAge(age.substring(0, age.length() - 2 > 0 ? age.length() - 2 : 1));// 年龄
                        } else {
                            user.setAge(cell.getStringCellValue());// 年龄
                        }
                    }
                }

            }
            // 添加到list
            userList.add(user);*/
            positioninfoList.add(positioninfo);
        }
        return positioninfoList;
    }
    /**
     * 验证EXCEL文件
     * @param filePath
     * @return
     */

    public boolean validateExcel(String filePath) {
        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
            errorMsg = "文件名不是excel格式";
            return false;
        }
        return true;
    }

    // @描述：是否是2003的excel，返回true是2003
    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    // @描述：是否是2007的excel，返回true是2007
    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }



}
