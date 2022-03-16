/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.modelo;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import dominio.controlador.ControladorVenta;
import dominio.modelo.*;

/**
 *
 * @author Personal
 */
public class FacturaPDF {
    
    //Todo
    /*
    * Utilizar patron Strategy para generar factura pdf
    * Utilizar patron Adapter para la libreria iText
    */
    
    private void pdf() {
        ControladorVenta controladorVenta = new ControladorVenta();
        DatosEmpresa datosEmpresa = new DatosEmpresa();
        Cliente datosCliente = new Cliente();
        float totalPagar = 0.0f;
        try {
            int id = controladorVenta.idVenta();
            FileOutputStream archivo;
            File file = new File("src/pdf/venta" + id + ".pdf");

            archivo = new FileOutputStream(file);

            Document documento = new Document();
            PdfWriter.getInstance(documento, archivo);
            documento.open();

            //Encabezado del pdf//
            Image imagen = Image.getInstance("src/vista/img/logo-pdf.jpg");
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
            fecha.add(Chunk.NEWLINE);
            Date fechaSistema = new Date();
            fecha.add("Factura: " + id + "\nFecha: " + new SimpleDateFormat("dd-MM-yyyy").format(fechaSistema) + "\n\n");

            PdfPTable encabezado = new PdfPTable(4);
            encabezado.setWidthPercentage(100);
            encabezado.getDefaultCell().setBorder(0);

            float[] columnaEncabezado = new float[]{20f, 40f, 70f, 40f};
            encabezado.setWidths(columnaEncabezado);
            encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            encabezado.addCell(imagen);

            String NITEmpresa = datosEmpresa.getNit();
            String nombreEmpresa = datosEmpresa.getNombre();
            String telefonoEmpresa = datosEmpresa.getTelefono();
            String direccionEmpresa = datosEmpresa.getDireccion();

            encabezado.addCell("");
            encabezado.addCell("NIT: " + NITEmpresa + "\nNombre: "
                    + nombreEmpresa + "\nTelefono: " + telefonoEmpresa + "\nDireccion: "
                    + direccionEmpresa);
            encabezado.addCell(fecha);

            documento.add(encabezado);

            //Informacion cliente//
            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);
            cliente.add("Datos de los clientes" + "\n\n");
            documento.add(cliente);

            PdfPTable tablaCliente = new PdfPTable(5);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(0);

            float[] columnaCliente = new float[]{30f, 50f, 40f, 40f, 50f};
            tablaCliente.setWidths(columnaCliente);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            //tablaCliente.addCell(imagen);

            PdfPCell cliente1 = new PdfPCell(new Phrase("Documento", negrita));
            PdfPCell cliente2 = new PdfPCell(new Phrase("Nombre", negrita));
            PdfPCell cliente3 = new PdfPCell(new Phrase("Telefono", negrita));
            PdfPCell cliente4 = new PdfPCell(new Phrase("Dirección", negrita));
            PdfPCell cliente5 = new PdfPCell(new Phrase("Correo", negrita));

            cliente1.setBorder(0);
            cliente2.setBorder(0);
            cliente3.setBorder(0);
            cliente4.setBorder(0);
            cliente5.setBorder(0);

            tablaCliente.addCell(cliente1);
            tablaCliente.addCell(cliente2);
            tablaCliente.addCell(cliente3);
            tablaCliente.addCell(cliente4);
            tablaCliente.addCell(cliente5);

            tablaCliente.addCell(datosCliente.getDocumentoCliente());
            tablaCliente.addCell(datosCliente.getNombreCliente());
            tablaCliente.addCell(datosCliente.getNumTelCliente());
            tablaCliente.addCell(datosCliente.getDireccionCliente());
            tablaCliente.addCell(datosCliente.getCorreoCliente());

            documento.add(tablaCliente);

            documento.add(Chunk.NEWLINE);
            //Informacion productos//
            PdfPTable tablaProductos = new PdfPTable(5);
            tablaProductos.setWidthPercentage(100);
            tablaProductos.getDefaultCell().setBorder(0);

            float[] columnaProductos = new float[]{10f, 50f, 10f, 15f, 20f};
            tablaCliente.setWidths(columnaProductos);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            tablaCliente.addCell(imagen);

            PdfPCell producto1 = new PdfPCell(new Phrase("Código", negrita));
            PdfPCell producto2 = new PdfPCell(new Phrase("Nombre", negrita));
            PdfPCell producto3 = new PdfPCell(new Phrase("Cantidad", negrita));
            PdfPCell producto4 = new PdfPCell(new Phrase("Precio", negrita));
            PdfPCell producto5 = new PdfPCell(new Phrase("Precio Total", negrita));

            producto1.setBorder(0);
            producto2.setBorder(0);
            producto3.setBorder(0);
            producto4.setBorder(0);
            producto5.setBorder(0);

            producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto5.setBackgroundColor(BaseColor.LIGHT_GRAY);

            tablaProductos.addCell(producto1);
            tablaProductos.addCell(producto2);
            tablaProductos.addCell(producto3);
            tablaProductos.addCell(producto4);
            tablaProductos.addCell(producto5);

            for (int i = 0; i < jTable_Venta_Tab1.getRowCount(); i++) {
                String codigo = jTable_Venta_Tab1.getValueAt(i, 0).toString();
                String nombre = jTable_Venta_Tab1.getValueAt(i, 1).toString();
                String cantidad = jTable_Venta_Tab1.getValueAt(i, 2).toString();
                String precio = jTable_Venta_Tab1.getValueAt(i, 3).toString();
                String precioTotal = jTable_Venta_Tab1.getValueAt(i, 4).toString();

                tablaProductos.addCell(codigo);
                tablaProductos.addCell(nombre);
                tablaProductos.addCell(cantidad);
                tablaProductos.addCell(precio);
                tablaProductos.addCell(precioTotal);
            }

            documento.add(tablaProductos);

            Paragraph informacion = new Paragraph();
            informacion.add(Chunk.NEWLINE);
            informacion.add("Total a Pagar: " + totalPagar);
            informacion.setAlignment(Element.ALIGN_RIGHT);
            documento.add(informacion);

            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("GRACIAS POR SU COMPRA");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            documento.add(mensaje);

            documento.close();
            archivo.close();
            Desktop.getDesktop().open(file);
        } catch (DocumentException | IOException e) {
            System.out.println(e.toString());
        }
    }
}
