package webstationapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webstationapi.DTO.ForfaitCartDTO;
import webstationapi.Entity.LiftBooking;
import webstationapi.Entity.Token;
import webstationapi.Repository.TokenRepository;

@Service
public class LiftService {

   /* public Document makePdf(Long iduser, List<LiftBooking> allBookByUser) throws FileNotFoundException, DocumentException {
        
        Document document = new Document();
        UUID uuid = UUID.randomUUID();
        String name = uuid.toString() + ".pdf";
        PdfWriter.getInstance(document, new FileOutputStream(name));
        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.BLACK);
        Paragraph paragraph = new Paragraph();


        Chunk chunk = new Chunk("Facture : " + uuid.toString(), font);
        paragraph.add(chunk);
        paragraph.add(Chunk.NEWLINE);

        Double fullPrice = 0.0;

        for (LiftBooking liftBooking : allBookByUser) {
            String line = liftBooking.getIdLift().toString() + " " + liftBooking.getNbFois() + " = " + liftBooking.getPrice().toString();
            fullPrice += liftBooking.getPrice();
            Chunk tmpChunk = new Chunk(line, font);
            paragraph.add(tmpChunk);
            paragraph.add(Chunk.NEWLINE);
        }

        Chunk finalChunk = new Chunk("Total Price " + fullPrice.toString(), font);
        paragraph.add(finalChunk);
        document.add(paragraph);

        document.close();
        return document;
    }
*/
}
