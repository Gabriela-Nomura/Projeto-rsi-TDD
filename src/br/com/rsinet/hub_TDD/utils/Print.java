package br.com.rsinet.hub_TDD.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Print {

    public static void takeSnapShot(String nomeDoArquivoImagem, WebDriver driver) throws Exception {

        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        String imageFileDir = "C://Users//gabriela.nomura//eclipse-workspace//br.com.rsinet.hub_TDD//src//br//com//rsinet//hub_TDD//screenShots//";
        FileUtils.copyFile(srcFile, new File(imageFileDir, nomeDoArquivoImagem + ".png"));

        
    }
    }





