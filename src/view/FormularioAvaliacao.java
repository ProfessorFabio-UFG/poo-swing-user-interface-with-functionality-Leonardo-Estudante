package view;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class FormularioAvaliacao extends JFrame {

	private JTextField campoCodigo, campoNome;
    private JRadioButton feminino, masculino;
    private JTextArea campoCV;
    private JComboBox<String> comboInteresse, comboAtuacao;

    private List<Registro> registros = new ArrayList<>();
    private int indiceAtual = -1;

    public FormularioAvaliacao() {
        super("Ficha de Avaliação");

        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();

        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem itemSalvar = new JMenuItem("Salvar");
        JMenuItem itemSair = new JMenuItem("Sair");

        JMenu menuEnviar = new JMenu("Enviar");
        JMenuItem itemEmail = new JMenuItem("Email");
        JMenuItem itemImpressora = new JMenuItem("Impressora");

        menuArquivo.add(itemSalvar);
        menuArquivo.add(menuEnviar);
        menuArquivo.add(itemSair);
        menuEnviar.add(itemEmail);
        menuEnviar.add(itemImpressora);

        menuBar.add(menuArquivo);
        setJMenuBar(menuBar);

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

        campoCodigo = new JTextField(15);
        campoNome = new JTextField(15);
        feminino = new JRadioButton("Feminino");
        masculino = new JRadioButton("Masculino");

        ButtonGroup grupoSexo = new ButtonGroup();
        grupoSexo.add(feminino);
        grupoSexo.add(masculino);

        painelDados.add(new JLabel("Código:"));
        painelDados.add(campoCodigo);

        painelDados.add(new JLabel("Nome:"));
        painelDados.add(campoNome);

        painelDados.add(new JLabel("Sexo:"));
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
        campoCV = new JTextArea(6, 30);
        painelCV.add(new JScrollPane(campoCV), BorderLayout.CENTER);

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

        comboInteresse = new JComboBox<>(new String[]{"Desenvolvedor", "Analista", "Designer"});
        comboAtuacao = new JComboBox<>(new String[]{"Programação", "Teste", "UX/UI"});

        painelAreas.add(new JLabel("Interesse:"));
        painelAreas.add(comboInteresse);
        painelAreas.add(new JLabel("Atuação:"));
        painelAreas.add(comboAtuacao);

        painelPrincipal.add(Box.createVerticalStrut(10));
        painelPrincipal.add(painelDados);
        painelPrincipal.add(Box.createVerticalStrut(15));
        painelPrincipal.add(painelCV);
        painelPrincipal.add(Box.createVerticalStrut(15));
        painelPrincipal.add(painelAreas);
        painelPrincipal.add(Box.createVerticalStrut(10));

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        painelBotoes.setBackground(Color.GREEN);

        JButton botaoSalvar = new JButton("Salvar");
        JButton botaoAnterior = new JButton("Anterior");
        JButton botaoProximo = new JButton("Próximo");
        JButton botaoNovo = new JButton("Novo");
        JButton botaoCancelar = new JButton("Cancelar");

        painelBotoes.add(botaoSalvar);
        painelBotoes.add(botaoAnterior);
        painelBotoes.add(botaoProximo);
        painelBotoes.add(botaoNovo);
        painelBotoes.add(botaoCancelar);

        add(painelPrincipal, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        botaoSalvar.addActionListener(e -> salvarDados());
        botaoNovo.addActionListener(e -> limparCampos());
        botaoCancelar.addActionListener(e -> limparCampos());
        botaoAnterior.addActionListener(e -> mostrarAnterior());
        botaoProximo.addActionListener(e -> mostrarProximo());

        itemSalvar.addActionListener(e -> salvarDados());
        itemSair.addActionListener(e -> System.exit(0));
        itemEmail.addActionListener(e -> JOptionPane.showMessageDialog(this, "Enviado por email!"));
        itemImpressora.addActionListener(e -> JOptionPane.showMessageDialog(this, "Enviado para a impressora!"));

        setSize(600, 540);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void salvarDados() {
        String codigo = campoCodigo.getText();
        String nome = campoNome.getText();
        String sexo = feminino.isSelected() ? "Feminino" : masculino.isSelected() ? "Masculino" : "Não informado";
        String curriculum = campoCV.getText();
        String interesse = (String) comboInteresse.getSelectedItem();
        String atuacao = (String) comboAtuacao.getSelectedItem();

        Registro r = new Registro(codigo, nome, sexo, curriculum, interesse, atuacao);
        registros.add(r);
        indiceAtual = registros.size() - 1;

        JOptionPane.showMessageDialog(this, "Dados salvos com sucesso.");
    }

    private void limparCampos() {
        campoCodigo.setText("");
        campoNome.setText("");
        campoCV.setText("");
        feminino.setSelected(false);
        masculino.setSelected(false);
        comboInteresse.setSelectedIndex(0);
        comboAtuacao.setSelectedIndex(0);
    }

    private void mostrarRegistro(int indice) {
        if (indice >= 0 && indice < registros.size()) {
            Registro r = registros.get(indice);
            campoCodigo.setText(r.codigo);
            campoNome.setText(r.nome);
            campoCV.setText(r.cv);
            feminino.setSelected("Feminino".equals(r.sexo));
            masculino.setSelected("Masculino".equals(r.sexo));
            comboInteresse.setSelectedItem(r.interesse);
            comboAtuacao.setSelectedItem(r.atuacao);
            indiceAtual = indice;
        }
    }

    private void mostrarAnterior() {
        if (indiceAtual > 0) {
            mostrarRegistro(indiceAtual - 1);
        } else {
            JOptionPane.showMessageDialog(this, "Já está no primeiro registro.");
        }
    }

    private void mostrarProximo() {
        if (indiceAtual < registros.size() - 1) {
            mostrarRegistro(indiceAtual + 1);
        } else {
            JOptionPane.showMessageDialog(this, "Já está no último registro.");
        }
    }

    private static class Registro {
        String codigo, nome, sexo, cv, interesse, atuacao;

        Registro(String codigo, String nome, String sexo, String cv, String interesse, String atuacao) {
            this.codigo = codigo;
            this.nome = nome;
            this.sexo = sexo;
            this.cv = cv;
            this.interesse = interesse;
            this.atuacao = atuacao;
        }
    }
}
