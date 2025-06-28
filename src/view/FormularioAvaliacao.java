package view;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class FormularioAvaliacao extends JFrame {

	private static final long serialVersionUID = -1829604351552734059L;

	public FormularioAvaliacao() {
        super("Ficha de Avaliação");

        setLayout(new BorderLayout());

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel painelDados = new JPanel(new GridLayout(3, 2, 10, 10));
        painelDados.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLUE),
            "Dados",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 12),
            Color.BLUE
        ));
        painelDados.setPreferredSize(new Dimension(500, 120));

        painelDados.add(new JLabel("Código:"));
        painelDados.add(new JTextField(15));

        painelDados.add(new JLabel("Nome:"));
        painelDados.add(new JTextField(15));

        painelDados.add(new JLabel("Sexo:"));

        JRadioButton feminino = new JRadioButton("Feminino");
        JRadioButton masculino = new JRadioButton("Masculino");

        ButtonGroup grupoSexo = new ButtonGroup();
        grupoSexo.add(feminino);
        grupoSexo.add(masculino);

        JPanel painelSexo = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, -2));
        painelSexo.add(feminino);
        painelSexo.add(masculino);

        painelDados.add(painelSexo);

        JPanel painelCV = new JPanel(new BorderLayout());
        painelCV.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLUE),
            "Curriculum Vitae",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 12),
            Color.BLUE
        ));
        painelCV.setPreferredSize(new Dimension(500, 150));
        painelCV.add(new JScrollPane(new JTextArea(6, 30)), BorderLayout.CENTER);

        JPanel painelAreas = new JPanel(new GridLayout(2, 2, 10, 10));
        painelAreas.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLUE),
            "Áreas",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 12),
            Color.BLUE
        ));
        painelAreas.setPreferredSize(new Dimension(500, 90));

        painelAreas.add(new JLabel("Interesse:"));
        painelAreas.add(new JComboBox<>(new String[]{"Desenvolvedor", "Analista", "Designer"}));

        painelAreas.add(new JLabel("Atuação:"));
        painelAreas.add(new JComboBox<>(new String[]{"Programação", "Teste", "UX/UI"}));

        painelPrincipal.add(Box.createVerticalStrut(10));
        painelPrincipal.add(painelDados);
        painelPrincipal.add(Box.createVerticalStrut(15));
        painelPrincipal.add(painelCV);
        painelPrincipal.add(Box.createVerticalStrut(15));
        painelPrincipal.add(painelAreas);
        painelPrincipal.add(Box.createVerticalStrut(10));

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        painelBotoes.setBackground(Color.GREEN);
        painelBotoes.add(new JButton("Salvar"));
        painelBotoes.add(new JButton("Anterior"));
        painelBotoes.add(new JButton("Próximo"));
        painelBotoes.add(new JButton("Novo"));
        painelBotoes.add(new JButton("Cancelar"));

        add(painelPrincipal, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        setSize(600, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
