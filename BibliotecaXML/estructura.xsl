<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">
    <html>
      <head>
        <title>Tabla de Libros</title>
        <style>
          body {
            font-family: Arial, sans-serif;
            margin: 20px;
          }
          h1 {
            text-align: center;
          }
          table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
          }
          th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
          }
          th {
            background-color: #f2f2f2;
          }
        </style>
      </head>
      <body>
        <h2>Libros</h2>
        <table border="1">
          <tr>
            <th>Título</th>
            <th>ISBN</th>
            <th>Autor</th>
            <th>Fecha</th>
            <th>Categoría</th>
            <th>Género</th>
          </tr>
          <xsl:apply-templates select="/biblioteca/libros"/>
        </table>
      </body>
    </html>
  </xsl:template>

  <xsl:template match="libros">
    <tr>
      <td><xsl:value-of select="titulo"/></td>
      <td><xsl:value-of select="isbn"/></td>
      <td><xsl:value-of select="autor"/></td>
      <td><xsl:value-of select="fecha"/></td>
      <td><xsl:value-of select="categoria"/></td>
      <td><xsl:value-of select="genero"/></td>
    </tr>
  </xsl:template>

</xsl:stylesheet>