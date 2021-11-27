import java.awt.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Lobby extends JFrame {

    public Lobby() {
        final var lobbyScreen = createLobbyScreen();
        lobbyScreen.add(createSidebar(), BorderLayout.EAST);
        lobbyScreen.add(createMatchesTable());
    }

    private JFrame createLobbyScreen() {
        final var lobbyScreen = new JFrame();
        lobbyScreen.setVisible(true);
        lobbyScreen.setSize(1366, 768);
        lobbyScreen.setTitle("Lobby | Socket Chess");
        lobbyScreen.setLocationRelativeTo(null);
        lobbyScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        return lobbyScreen;
    }

    private JPanel createSidebar() {
        final var sidebar = new JPanel();
        sidebar.add(createSidebarButton("criar partida"));
        sidebar.add(createSidebarButton("conectar à partida"));
        return sidebar;
    }

    private JButton createSidebarButton(String title) {
        final var sidebarButton = new JButton(title);
        sidebarButton.setSize(200, 30);
        return sidebarButton;
    }

    private JTable createMatchesTable() {
        final String data[][] = {
            { "João", new Date().toString(), "17636" },
            { "Pedro", new Date().toString(), "17636" },
            { "Marcos", new Date().toString(), "17636" },
            { "João", new Date().toString(), "17636" },
            { "Pedro", new Date().toString(), "17636" }
        };
        final String column[] = { "Nome do jogador", "Hora criação", "Porta" };

        final var matchesTable = new JTable();
        matchesTable.setModel(new DefaultTableModel(data, column) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        matchesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        matchesTable.setAutoCreateRowSorter(true);
        matchesTable.getTableHeader().setReorderingAllowed(false);
        matchesTable.setVerifyInputWhenFocusTarget(false);
        return matchesTable;
    }
}
