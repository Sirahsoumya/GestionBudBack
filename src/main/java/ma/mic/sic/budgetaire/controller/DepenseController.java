package ma.mic.sic.budgetaire.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.mic.sic.budgetaire.entity.DemandeTransfert;
import ma.mic.sic.budgetaire.entity.Depense;
import ma.mic.sic.budgetaire.entity.Recette;
import ma.mic.sic.budgetaire.repository.DepenseRepository;



@RestController
@RequestMapping(value = "depenses")
@CrossOrigin(origins = "http://localhost:4200")
public class DepenseController {

	@Autowired
	private DepenseRepository depenseRepository;
	 private static String[] columns = { "Date d'engagement", "Montant d'engagement", "Mantant crédit",
	    "Crédir disponible","Date de visa","Imputation budgétaire","Nom partie prenante","Totatl article" };

	@PostMapping("/save")
	public void Save(@RequestBody Depense depense) {
		depenseRepository.save(depense);
	}

	@DeleteMapping("/delete/{idDepense}")
	public void Delete(@PathVariable(required = true) String  idDepense) {
		
		 Depense depense =depenseRepository.findById(Integer.parseInt( idDepense));
		 depenseRepository.delete(depense);
	}

	@GetMapping("/all")
	public List<Depense> findAll() {
		return depenseRepository.findAll();
	}
	
	
	// export tableau depense to Excel
    @GetMapping("/fichierExcelDepense")
    public void generateExcel(HttpServletResponse response) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        
        // le style des entetes
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.BLUE_GREY.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        
        
        Sheet sheet = workbook.createSheet("Depense");
        List<Depense> depenses = depenseRepository.findAll();
        // Create a Row
        Row headerRow = sheet.createRow(0);



        for (int i = 0; i < columns.length; i++) {
          Cell cell = headerRow.createCell(i);
          cell.setCellValue(columns[i]);
          cell.setCellStyle(headerCellStyle);
        }
        
        int rowNum = 1;
        for(Depense depense : depenses) {
             Row row = sheet.createRow(rowNum++);
              row.createCell(0).setCellValue(depense.getDateDengagement());
              row.createCell(1).setCellValue(depense.getMantantDengagement());
              row.createCell(2).setCellValue(depense.getMontantCredit());    
              row.createCell(3).setCellValue(depense.getCreditDispo());   
              row.createCell(4).setCellValue(depense.getDateVisa()); 
              row.createCell(5).setCellValue(depense.getImputationBudgetaires()); 
              row.createCell(6).setCellValue(depense.getNomPartiesPrenantes()); 
              row.createCell(7).setCellValue(depense.getTotalArticle()); 
             
        }
        // Resize all columns to fit the content size
        for (int i = 0; i < columns.length; i++) {
          sheet.autoSizeColumn(i);
        }
        FileOutputStream fileOut = new FileOutputStream("Depense.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        
         InputStream inputStream = new FileInputStream(new File("Depense.xlsx")); //load the file
         IOUtils.copy(inputStream, response.getOutputStream());
         response.setContentType("application/application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition",
                    "attachment; filename=Depense.xlsx");
          response.flushBuffer();

}
    
    @GetMapping("/findId/{idDepense}")
	public Depense findDepenseById(@PathVariable(required = true) int idDepense)  {
		return depenseRepository.findById(idDepense);	
	}
	
	@PatchMapping("/dep/{idDepense}")
	public void update(@RequestBody  Depense depense,@PathVariable(required = true) int idDepense ) {
		depenseRepository.save(depense);
	}

}
