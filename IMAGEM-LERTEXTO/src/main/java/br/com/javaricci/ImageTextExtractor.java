package br.com.javaricci;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ImageTextExtractor extends JFrame {
	private static final long serialVersionUID = 1L;

	private JTextArea textArea;
    private JButton selectImageButton;
    private JButton saveTextButton;
    private JFileChooser fileChooser;

    public ImageTextExtractor() {
        // Configure JFrame
        setTitle("Image Text Extractor");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializa Componentes
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        selectImageButton = new JButton("Select Image");
        saveTextButton = new JButton("Save Text");

        fileChooser = new JFileChooser();

        // Adiciona Componentes no JFrame
        JPanel panel = new JPanel();
        panel.add(selectImageButton);
        panel.add(saveTextButton);

        add(new JScrollPane(textArea), "Center");
        add(panel, "South");



        selectImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        String extractedText = extractTextFromImage(selectedFile);
                        textArea.setText(extractedText);
                    } catch (TesseractException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Erro ao extrair texto da imagem.");
                    }
                }
            }
        });



        saveTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnValue = fileChooser.showSaveDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    try (FileWriter writer = new FileWriter(fileToSave)) {
                        writer.write(textArea.getText());
                        JOptionPane.showMessageDialog(null, "Texto salvo com sucesso.");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Erro ao salvar texto no arquivo.");
                    }
                }
            }
        });
    }



    private String extractTextFromImage(File imageFile) throws TesseractException {
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("E:\\Tess4J\\tessdata"); // Configure o caminho para o diretório tessdata da Biblioteca Tesseract OCR
        tesseract.setLanguage("por"); // Definir idioma para português
        return tesseract.doOCR(imageFile);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImageTextExtractor().setVisible(true);
            }
        });
    }
    
}
