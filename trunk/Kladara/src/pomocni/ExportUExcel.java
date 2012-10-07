/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pomocni;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
import jxl.SheetSettings;
import jxl.Workbook;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import quick.dbtable.DBTable;

/**
 *
 * @author damirl
 */
public class ExportUExcel {
    //Dio...

    static String[] abeceda = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q"};

    public static void exportTabliceUExcel(String zaglavlje, DBTable tablica, String nazivDatoteke, String koloneZaSumu, String koloneUlogSaldo) {
        int brojKolona = tablica.getColumnCount();
        int brojRedova = tablica.getRowCount();
        if (brojRedova == 0) {
            return;
        }
        int kolona = 0;
        int praznihRedova = 2;
        int redPozicija = praznihRedova;
        //Teski shit getanje value-a ide ne po visible kolone vec po stvarnom indexu...
        int kolonaValue = 0;
        String vrijednost;
        double broj = 0;
        boolean numerickaVrijednost = false;
        try {
            String excelDatoteka = Pomocna.mapaIzvestaja + nazivDatoteke.trim();
            WritableWorkbook excel = Workbook.createWorkbook(new File(excelDatoteka));
            WritableSheet list = excel.createSheet("Lista", 0);
            SheetSettings postavkeLista = list.getSettings();
            postavkeLista.setVerticalFreeze(praznihRedova + 1);
            postavkeLista.setDefaultColumnWidth(12);


            //Postavke glave
            Label labelGlava;
            //Format glave
            WritableFont glavaFont = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD);
            WritableCellFormat glavaFormat = new WritableCellFormat(glavaFont);
            glavaFormat.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            glavaFormat.setBackground(jxl.format.Colour.LAVENDER);

            // Postavke redova
            //String declare...
            Label labelRedString;
            jxl.write.Number labelRedBroj;

            //Format reda string
            WritableFont redFont = new WritableFont(WritableFont.ARIAL, 10);
            WritableCellFormat redFormat = new WritableCellFormat(redFont);
            redFormat.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            redFormat.setBackground(jxl.format.Colour.WHITE);
            //Format reda broj            
            WritableCellFormat brojFormat = new WritableCellFormat(NumberFormats.FLOAT);
            brojFormat.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            brojFormat.setBackground(jxl.format.Colour.WHITE);
            brojFormat.setFont(redFont);

            // Postavke formule, totali, ROI            
            Formula formula;
            Label labelTotal;
            WritableFont formulaFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
            WritableCellFormat nogaFormat = new WritableCellFormat(formulaFont);
            WritableCellFormat totalFormat = new WritableCellFormat(NumberFormats.FLOAT);
            WritableCellFormat roiFormat = new WritableCellFormat(NumberFormats.PERCENT_FLOAT);
            //  totalFormat.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            // totalFormat.setBackground(jxl.format.Colour.WHITE);
            totalFormat.setFont(formulaFont);
            roiFormat.setFont(formulaFont);

            // Ispisi zaglavlje
            if (zaglavlje != null) {
                WritableCellFormat zaglavljeFormat = new WritableCellFormat(glavaFont);
                //glavaFormat.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
                //glavaFormat.setBackground(jxl.format.Colour.LAVENDER);
                Label labelZaglavlje = new Label(0, 0, zaglavlje, zaglavljeFormat);
                list.addCell(labelZaglavlje);
            }

            // Ispisi header-e kolona
            for (int i = 0; i < brojKolona; i++) {
                if (tablica.getColumn(i).isVisible()) {
                    vrijednost = tablica.getColumn(i).getHeaderValue().toString();
                    labelGlava = new Label(kolona, redPozicija, vrijednost, glavaFormat);
                    list.addCell(labelGlava);
                    kolona++;
                }
            }
            //Reset
            kolona = 0;
            redPozicija++;
            //Ispisi redove
            for (int i = 0; i < brojRedova; i++) {
                for (int j = 0; j < brojKolona; j++) {
                    if (tablica.getColumn(j).isVisible()) {
                        vrijednost = tablica.getValueAt(i, kolonaValue).toString();
                        //Provjeri da li je string broj
                        try {
                            numerickaVrijednost = false;
                            broj = Double.parseDouble(vrijednost);
                            numerickaVrijednost = true;
                        } catch (Exception e) {
                            //Supress
                        }
                        if (numerickaVrijednost) {
                            labelRedBroj = new jxl.write.Number(kolona, redPozicija, broj, brojFormat);
                            list.addCell(labelRedBroj);
                        } else {
                            labelRedString = new Label(kolona, redPozicija, vrijednost, redFormat);
                            list.addCell(labelRedString);
                        }
                        kolona++;
                    }
                    kolonaValue++;
                }
                redPozicija++;
                kolonaValue = 0;
                kolona = 0;
            }
            //Formule sume
            int odReda = praznihRedova + 2;
            int doReda = --odReda + brojRedova;
            int kolonaZaFormuluInt = 0;
            String kolonaZaFormulu;
            if (koloneZaSumu != null) {
                //Red totala
                labelTotal = new Label(0, redPozicija, "Total", nogaFormat);
                list.addCell(labelTotal);
                Scanner skener = new Scanner(koloneZaSumu);
                while (skener.hasNext()) {
                    kolonaZaFormuluInt = skener.nextInt();
                    kolonaZaFormulu = abeceda[kolonaZaFormuluInt];
                    formula = new Formula(kolonaZaFormuluInt, redPozicija, "SUM(" + kolonaZaFormulu + odReda + ":" + kolonaZaFormulu + doReda + ")", totalFormat);
                    list.addCell(formula);
                }
                redPozicija++;
            }
            //ROI
            if (koloneUlogSaldo != null) {
                labelTotal = new Label(0, redPozicija, "ROI", nogaFormat);
                list.addCell(labelTotal);
                Scanner skener = new Scanner(koloneUlogSaldo);
                String ulogKolona = null;
                String saldoKolona = null;
                while (skener.hasNext()) {
                    kolonaZaFormuluInt = skener.nextInt();
                    kolonaZaFormulu = abeceda[kolonaZaFormuluInt];
                    if (ulogKolona == null) {
                        ulogKolona = kolonaZaFormulu;
                    } else {
                        saldoKolona = kolonaZaFormulu;
                    }
                }
                formula = new Formula(kolonaZaFormuluInt, redPozicija, "(" + saldoKolona + redPozicija + "/" + ulogKolona + redPozicija + ")", roiFormat);
                list.addCell(formula);
            }
            redPozicija++;
            excel.write();
            excel.close();
            Runtime.getRuntime().exec("cmd.exe /c " + excelDatoteka);
        } catch (IOException ex) {
            Poruka.greska(null, ex.getMessage());
        } catch (WriteException ex) {
            Poruka.greska(null, ex.getMessage());
        }
    }
}
