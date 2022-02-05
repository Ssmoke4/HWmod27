package io;
import model.statistic;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {
    public XlsWriter() {

    }
    public static void writeWorkbook(List<statistic> statistics, String filepath)throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Статистика");
        sheet.setColumnWidth(0, 8000);
        sheet.setColumnWidth(1, 9000);
        sheet.setColumnWidth(2, 10000);
        sheet.setColumnWidth(3, 10000);
        sheet.setColumnWidth(4, 10000);



        Row row = sheet.createRow(0);
        CellStyle style = wb.createCellStyle();
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
        style.setAlignment(HorizontalAlignment.CENTER);

        //Шрифт
        Font font = wb.createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 12);
        font.setBold(true);
        style.setFont(font);


        Cell head0 = row.createCell(0);
        head0.setCellValue("Профиль обучения");
        head0.setCellStyle(style);
        Cell head1 = row.createCell(1);
        head1.setCellValue("Средний балл за экзамены по профилю");
        head1.setCellStyle(style);
        Cell head2 = row.createCell(2);
        head2.setCellValue("Количество студентов по профилю");
        head2.setCellStyle(style);
        Cell head3 = row.createCell(3);
        head3.setCellValue("Количество университетов по профилю");
        head3.setCellStyle(style);
        Cell head4 = row.createCell(4);
        head4.setCellValue("Университеты");
        head4.setCellStyle(style);


        int rowNumber = 1;
        for (statistic statistic : statistics) {
            Row dataRow = sheet.createRow(rowNumber++);
            Cell profileCell = dataRow.createCell(0);
            profileCell.setCellValue(statistic.getProfile().getProfile_name());
            Cell avgScoreCell = dataRow.createCell(1);
            avgScoreCell.setCellValue(statistic.getAvgExam());
            Cell numberOfStudentsCell = dataRow.createCell(2);
            numberOfStudentsCell.setCellValue(statistic.getNumOfStudents());
            Cell numberOfUniversitiesCell = dataRow.createCell(3);
            numberOfUniversitiesCell.setCellValue(statistic.getNumOfUniversity());
            Cell universitiesCell = dataRow.createCell(4);
            universitiesCell.setCellValue(statistic.getUniversityNames());
        }

        try (FileOutputStream outputStream = new FileOutputStream(filepath)) {
            wb.write(outputStream);
        }



    }
}
