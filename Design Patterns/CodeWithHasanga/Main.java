package CodeWithHasanga;


import Bridge.*;

public class Main {
    public static void main(String[] arg) {
        VideoEditor finalCutPro = new FinalCutPro();
        VideoEditor premierPro = new PremierPro();

        ExportOption highQualityExport = new HighQualityExport();
        ExportOption mediumQualityExport = new NormalQualityExport();

        finalCutPro.export(highQualityExport);
        finalCutPro.export(mediumQualityExport);

        premierPro.export(highQualityExport);
        premierPro.export(mediumQualityExport);
    }
}
