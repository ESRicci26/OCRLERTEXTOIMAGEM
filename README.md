Esse projeto JAVA SWING com repositório MAVEN e com Interface Gráfica do Usuário com um botão para buscar uma imagem em qualquer diretório e extrair o texto e informar na
JTEXTAREA e também tem um botão para gravar o texto extraído da imagem num arquivo *.TXT no diretório que será solicitado também em tela.
Esse código utiliza um software da linguagem "C" chamado "Tesseract OCR" para ler o conteúdo de texto que estiver numa imagem e para perfeito funcionamento deve seguir as instruções abaixo:

Configuração do Tesseract:
##########################

Certifique-se de que o Tesseract OCR está instalado na sua máquina.
Faça o download dos arquivos de treinamento do Tesseract (tessdata) e coloque-os em um diretório acessível.
Altere o caminho no método setDatapath para apontar para esse diretório.
Esse código cria uma interface gráfica com um botão para selecionar uma imagem e um botão para salvar o texto extraído.
O texto extraído é exibido em um JTextArea.
O Tesseract é utilizado para fazer a extração do texto da imagem.
Para configurar o Tesseract OCR para reconhecer e traduzir texto em Português do Brasil, você precisa baixar os arquivos de treinamento para o 
idioma Português do Brasil (por.traineddata) e configurá-lo no seu código.

Aqui estão os passos para ajustar o código:
===========================================
Baixar os dados de treinamento em Português:
--------------------------------------------
Baixe o arquivo por.traineddata do repositório oficial do Tesseract conforme link abaixo:
https://github.com/tesseract-ocr/tessdata

Configurar o caminho dos dados de treinamento:
----------------------------------------------
Coloque o arquivo por.traineddata no diretório tessdata que você especificou no seu projeto.

Alterar o código para usar o idioma Português:
----------------------------------------------
No método extractTextFromImage, configure o idioma para por (código para Português).
Site dos idiomas: https://tesseract-ocr.github.io/tessdoc/Data-Files-in-different-versions.html
