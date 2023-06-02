package Bridge;

public class PremierPro implements VideoEditor {
    @Override
    public void export(ExportOption exportOption) {
        System.out.print("Premier Pro: ");
        exportOption.performExport();
    }
}