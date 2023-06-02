package Bridge;

public class NormalQualityExport implements ExportOption {
    @Override
    public void performExport() {
        System.out.println("Exporting in medium quality");
    }
}