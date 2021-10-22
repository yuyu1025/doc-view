package com.liuzhihang.doc.view.ui;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.project.Project;
import com.intellij.ui.IdeBorderFactory;
import com.intellij.ui.components.labels.LinkLabel;
import com.intellij.util.ui.JBUI;
import com.liuzhihang.doc.view.DocViewBundle;
import com.liuzhihang.doc.view.config.Settings;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * @author liuzhihang
 * @date 2020/2/26 19:17
 */
public class SettingsForm {

    private static final TitledBorder titleTitleBorder = IdeBorderFactory.createTitledBorder(DocViewBundle.message("settings.doc.title"));
    private static final TitledBorder nameTitleBorder = IdeBorderFactory.createTitledBorder(DocViewBundle.message("settings.doc.name"));
    private static final TitledBorder descTitleBorder = IdeBorderFactory.createTitledBorder(DocViewBundle.message("settings.doc.desc"));
    private static final TitledBorder requiredTitleBorder = IdeBorderFactory.createTitledBorder(DocViewBundle.message("settings.doc.required"));
    private static final TitledBorder exportTitleBorder = IdeBorderFactory.createTitledBorder(DocViewBundle.message("settings.doc.export"));
    private static final TitledBorder lineMarkerTitleBorder = IdeBorderFactory.createTitledBorder(DocViewBundle.message("settings.doc.line.marker"));

    private final Project project;

    private JPanel rootPanel;

    private LinkLabel<String> supportLinkLabel;

    private JPanel titlePanel;
    private JCheckBox titleCommentTagCheckBox;
    private JCheckBox titleFullClassNameCheckBox;
    private JCheckBox titleSimpleClassNameCheckBox;
    private JCheckBox titleClassCommentCheckBox;

    private JPanel namePanel;
    private JCheckBox nameSwagger3CheckBox;
    private JCheckBox nameSwaggerCheckBox;
    private JCheckBox nameCommentTagCheckBox;
    private JCheckBox nameMethodCommentCheckBox;

    private JPanel docDescPanel;
    private JCheckBox descSwagger3CheckBox;
    private JCheckBox descSwaggerCheckBox;

    private JPanel requirePanel;
    private JCheckBox requireCommentTagCheckBox;

    private JPanel exportPanel;
    private JCheckBox mergeExportCheckBox;


    private JPanel lineMarkerPanel;
    private JCheckBox lineMarkerCheckBox;
    private JCheckBox interfaceLineMakerCheckBox;


    public SettingsForm(@NotNull Project project) {

        this.project = project;

        supportLinkLabel.setBorder(JBUI.Borders.emptyTop(20));
        supportLinkLabel.setIcon(AllIcons.Actions.Find);

        supportLinkLabel.setListener((source, data) -> new SupportForm().show(), null);

        initTitleBorder();
    }

    private void initTitleBorder() {

        titlePanel.setBorder(titleTitleBorder);
        namePanel.setBorder(nameTitleBorder);
        docDescPanel.setBorder(descTitleBorder);
        requirePanel.setBorder(requiredTitleBorder);
        exportPanel.setBorder(exportTitleBorder);
        lineMarkerPanel.setBorder(lineMarkerTitleBorder);
    }

    public boolean isModified() {

        Settings settings = Settings.getInstance(project);

        interfaceLineMakerCheckBox.setEnabled(lineMarkerCheckBox.isSelected());


        return titleCommentTagCheckBox.isSelected() != settings.getTitleUseCommentTag()
                || titleFullClassNameCheckBox.isSelected() != settings.getTitleUseFullClassName()
                || titleSimpleClassNameCheckBox.isSelected() != settings.getTitleUseSimpleClassName()
                || titleClassCommentCheckBox.isSelected() != settings.getTitleClassComment()
                || nameSwagger3CheckBox.isSelected() != settings.getNameUseSwagger3()
                || nameSwaggerCheckBox.isSelected() != settings.getNameUseSwagger()
                || nameCommentTagCheckBox.isSelected() != settings.getNameUseCommentTag()
                || nameMethodCommentCheckBox.isSelected() != settings.getNameMethodComment()
                || descSwagger3CheckBox.isSelected() != settings.getDescUseSwagger3()
                || descSwaggerCheckBox.isSelected() != settings.getDescUseSwagger()
                || requireCommentTagCheckBox.isSelected() != settings.getRequiredUseCommentTag()
                || mergeExportCheckBox.isSelected() != settings.getMergeExport()
                || lineMarkerCheckBox.isSelected() != settings.getLineMarker()
                || interfaceLineMakerCheckBox.isSelected() != settings.getInterfaceLineMaker();
    }

    public void apply() {

        Settings settings = Settings.getInstance(project);
        settings.setTitleUseCommentTag(titleCommentTagCheckBox.isSelected());
        settings.setTitleUseFullClassName(titleFullClassNameCheckBox.isSelected());
        settings.setTitleUseSimpleClassName(titleSimpleClassNameCheckBox.isSelected());
        settings.setTitleClassComment(titleClassCommentCheckBox.isSelected());
        settings.setNameUseSwagger3(nameSwagger3CheckBox.isSelected());
        settings.setNameUseSwagger(nameSwaggerCheckBox.isSelected());
        settings.setNameUseCommentTag(nameCommentTagCheckBox.isSelected());
        settings.setNameMethodComment(nameMethodCommentCheckBox.isSelected());
        settings.setDescUseSwagger3(descSwagger3CheckBox.isSelected());
        settings.setDescUseSwagger(descSwaggerCheckBox.isSelected());
        settings.setRequiredUseCommentTag(requireCommentTagCheckBox.isSelected());
        settings.setMergeExport(mergeExportCheckBox.isSelected());
        settings.setLineMarker(lineMarkerCheckBox.isSelected());
        settings.setInterfaceLineMaker(interfaceLineMakerCheckBox.isSelected());

        interfaceLineMakerCheckBox.setEnabled(lineMarkerCheckBox.isSelected());


    }

    public void reset() {
        Settings settings = Settings.getInstance(project);
        titleCommentTagCheckBox.setSelected(settings.getTitleUseCommentTag());
        titleClassCommentCheckBox.setSelected(settings.getTitleClassComment());
        titleFullClassNameCheckBox.setSelected(settings.getTitleUseFullClassName());
        titleSimpleClassNameCheckBox.setSelected(settings.getTitleUseSimpleClassName());
        nameSwagger3CheckBox.setSelected(settings.getNameUseSwagger3());
        nameSwaggerCheckBox.setSelected(settings.getNameUseSwagger());
        nameCommentTagCheckBox.setSelected(settings.getNameUseCommentTag());
        nameMethodCommentCheckBox.setSelected(settings.getNameMethodComment());
        descSwagger3CheckBox.setSelected(settings.getDescUseSwagger3());
        descSwaggerCheckBox.setSelected(settings.getDescUseSwagger());
        requireCommentTagCheckBox.setSelected(settings.getRequiredUseCommentTag());
        mergeExportCheckBox.setSelected(settings.getMergeExport());
        lineMarkerCheckBox.setSelected(settings.getLineMarker());
        interfaceLineMakerCheckBox.setSelected(settings.getInterfaceLineMaker());

        interfaceLineMakerCheckBox.setEnabled(lineMarkerCheckBox.isSelected());

    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
