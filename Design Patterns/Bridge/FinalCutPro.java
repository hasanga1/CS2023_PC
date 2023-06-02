package Bridge;

public class FinalCutPro implements VideoEditor {
    @Override
    public void export(ExportOption exportOption) {
        System.out.print("Final Cut Pro: ");
        exportOption.performExport();
    }
}