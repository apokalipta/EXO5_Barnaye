package fr.lixtec.form10.j2.tp.tp5;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.krysalis.barcode4j.impl.datamatrix.DataMatrixBean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

@WebServlet("/qrcode")
public class QRCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain; charset=UTF-8");
        resp.getWriter().println("Bienvenue sur le générateur de code-barres (/qrcode).");
        resp.getWriter().println("Utilisez la page d'accueil (index.html) pour envoyer code & libellé.");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String code = req.getParameter("code");
        String libelle = req.getParameter("libelle");
        String type = req.getParameter("type");

        if (code == null || libelle == null || type == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Champs requis : code, libelle, type");
            return;
        }
        if (!"datamatrix".equalsIgnoreCase(type)) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Type non supporté : " + type);
            return;
        }

        String message = "Le code du formulaire est " + code + ". Le libellé est " + libelle + ".";

        DataMatrixBean bean = new DataMatrixBean();

        resp.setContentType("image/png");
        resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");

        try (OutputStream out = resp.getOutputStream()) {
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(
                    out, "image/png", 300, BufferedImage.TYPE_BYTE_GRAY, false, 0);
            bean.generateBarcode(canvas, new String(message.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8));
            canvas.finish();
        }
    }
}
