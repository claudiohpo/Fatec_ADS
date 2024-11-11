import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;

public class AjusteColunaTabelas {
    private final JTable table;

    public AjusteColunaTabelas(JTable table) {
        this.table = table;
    }

    public void adjustColumns() {
        for (int column = 0; column < table.getColumnCount(); column++) {
            adjustColumn(column);
        }
    }

    private void adjustColumn(int column) {
        TableColumn tableColumn = table.getColumnModel().getColumn(column);
        int preferredWidth = tableColumn.getMinWidth();
        int maxWidth = tableColumn.getMaxWidth();

        for (int row = 0; row < table.getRowCount(); row++) {
            TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
            Component component = table.prepareRenderer(cellRenderer, row, column);
            int width = component.getPreferredSize().width + table.getIntercellSpacing().width;
            preferredWidth = Math.max(preferredWidth, width);

            // We've exceeded the maximum width, no need to check other rows
            if (preferredWidth >= maxWidth) {
                preferredWidth = maxWidth;
                break;
            }
        }
        tableColumn.setPreferredWidth(preferredWidth);
    }
}
