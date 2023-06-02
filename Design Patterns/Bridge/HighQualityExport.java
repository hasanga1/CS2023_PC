package Bridge;

public class HighQualityExport implements ExportOption {
    @Override
    public void performExport() {
        System.out.println("Exporting in high quality");
    }
}