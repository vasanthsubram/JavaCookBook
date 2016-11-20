package UI.basic;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.String;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class HierarchyViewer extends JPanel
        implements ActionListener, TreeSelectionListener {

    private JTree tree, interfaceTree;
    JButton openButton;
    JTextField fileNameTextField;
    JScrollPane treeScrollPane, interfaceTreeScrollPane;
    JTabbedPane tabbedPane = new JTabbedPane();
    List<Class> classes = new ArrayList<Class>(), classes_for_interfaces=new ArrayList();
    List<Class> enums = new ArrayList<Class>();
    List<Class> interfaces = new ArrayList<Class>();

    public HierarchyViewer() throws Exception {
        super(new BorderLayout());
        add(tabbedPane);
        openButton = new JButton("Select File...");
        fileNameTextField = new JTextField(50);
        fileNameTextField.addActionListener(this);
        openButton.addActionListener(this);
        JPanel panel = new JPanel();
        panel.add(fileNameTextField);
        panel.add(openButton);
        add(panel, BorderLayout.NORTH);
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(Object.class.getName());
        tree = new JTree(rootNode);
        treeScrollPane = new JScrollPane(tree);
        treeScrollPane.setPreferredSize(new Dimension(500, 300));
        tabbedPane.add("classes", treeScrollPane);

        DefaultMutableTreeNode interfaceRootNode = new DefaultMutableTreeNode(Object.class.getName());
        interfaceTree = new JTree(interfaceRootNode);
        interfaceTreeScrollPane = new JScrollPane(interfaceTree);
        interfaceTreeScrollPane.setPreferredSize(new Dimension(500, 300));
        tabbedPane.add("interfaces", interfaceTreeScrollPane);

    }

    private void printHierachy() throws Exception {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(Object.class);
        tree = new JTree(rootNode);
        extractClasses();
        
        for (int i = 0; i < 50; i++) {
            iterate(classes, rootNode);
        }
        rootNode.add(new DefaultMutableTreeNode(Enum.class));
        iterate(enums, rootNode);
    }

    void printInterfaceHierarchy() {
         DefaultMutableTreeNode interfaceRootNode = new DefaultMutableTreeNode(Object.class.getName());

         for(Class i: interfaces){
             interfaceRootNode.add(new DefaultMutableTreeNode(i));
             System.out.println(i.getClass());
         }
         iterateForInterface(classes_for_interfaces, interfaceRootNode);
//         for (int i = 0; i < 50; i++) {
//            iterateForInterface(classes_for_interfaces, interfaceRootNode);
//        }
//         iterate(interfaces,interfaceRootNode);

//         for (Class i : interfaces) {
//            DefaultMutableTreeNode iNode = new DefaultMutableTreeNode(i);
//            interfaceRootNode.add(iNode);
//            iterateForInterface(classes_dup, iNode);
//        }
        interfaceTree = new JTree(interfaceRootNode);
//        iterateForInterface(interfaces, interfaceRootNode);

    }

    void extractClasses() throws Exception {
        ZipFile zipFile = new ZipFile(fileNameTextField.getText());
        Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>) zipFile.entries();
        File file = new File(fileNameTextField.getText());
        ClassLoader loader = new URLClassLoader(new URL[]{file.toURI().toURL()});
        while (entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry) entries.nextElement();

            if (entry.getName().endsWith(".class")) {
                System.out.println("Found " + entry.getName().replaceAll("/", "\\.").replace(".class", ""));
                String className = entry.getName().replaceAll("/", "\\.").replace(".class", "");
                Class aClass = loader.loadClass(className);

                if (aClass.isEnum()) {
                    enums.add(aClass);
                } else {
                    if (aClass.isInterface()) {
                        interfaces.add(aClass);
                    } else {
                        classes.add(aClass);
                        classes_for_interfaces.add(aClass);
                    }
                }
            }
        }
    }

    /**
     * Build the hierarchy of classes in the jar, always starting with Object
     * Each call to this method builds, just the next level of the hierarchy tree.
     * 
     * In each call to this method, all the entries in the 'classes' parameter is searched
     * such that they have a super class in the partially built tree. If there is a parent,
     * then the class is added as a child.
     * 
     * Repeat the same process for enums starting with Enum class.
     *
     *
     * @param classes
     * @param rootNode
     */
    void iterate(List<Class> classes, DefaultMutableTreeNode rootNode) {
        Iterator<Class> it = classes.iterator();
        while (it.hasNext()) {
            Enumeration enumeration = rootNode.depthFirstEnumeration();
            Class currClass = it.next();
            while (enumeration.hasMoreElements()) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumeration.nextElement();
                if (node.getUserObject() == currClass.getSuperclass()) {
                    node.add(new DefaultMutableTreeNode(currClass));
                    it.remove();
                }

            }
        }
    }

    void iterateForInterface(List<Class> classes, DefaultMutableTreeNode rootNode) {
        Iterator<Class> it = classes.iterator();
        while (it.hasNext()) {
            Enumeration enumeration = rootNode.depthFirstEnumeration();
            Class currClass = it.next();
          
            while (enumeration.hasMoreElements()) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumeration.nextElement();
                if (Arrays.asList(currClass.getInterfaces()).contains(node.getUserObject())) {
                    node.add(new DefaultMutableTreeNode(currClass));
                    it.remove();
                }
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                fileNameTextField.setText(file.getAbsolutePath());
                try {
//                    printHierachy();
                    printInterfaceHierarchy();
                    treeScrollPane.setViewportView(tree);
                    interfaceTreeScrollPane.setViewportView(interfaceTree);
                    tree.expandRow(0);
                    repaint();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (node == null) {
            return;
        }

        Object nodeInfo = node.getUserObject();
        if (node.isLeaf()) {
            nodeInfo.toString();
        } else {
        }
    }

    private static void createAndShowGUI() throws Exception {

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Couldn't use system look and feel.");
        }

        //Create and set up the window.
        JFrame frame = new JFrame("Class Hierarchy Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new HierarchyViewer());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                try {
                    createAndShowGUI();
                } catch (Exception ex) {
                    Logger.getLogger(HierarchyViewer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
