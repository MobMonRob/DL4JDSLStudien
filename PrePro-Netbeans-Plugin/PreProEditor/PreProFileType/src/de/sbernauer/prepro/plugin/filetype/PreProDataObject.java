/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.sbernauer.prepro.plugin.filetype;

import java.io.IOException;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.MIMEResolver;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.MultiFileLoader;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

@Messages({
    "LBL_PrePro_LOADER=Files of PrePro"
})
@MIMEResolver.ExtensionRegistration(
        displayName = "#LBL_PrePro_LOADER",
        mimeType = "text/x-prepro",
        extension = {"prepro", "PREPRO"}
)
@DataObject.Registration(
        mimeType = "text/x-prepro",
        iconBase = "de/sbernauer/prepro/plugin/filetype/SyntaxColoringANTLR-CMinusIcon.png",
        displayName = "#LBL_PrePro_LOADER",
        position = 300
)
@ActionReferences({
    @ActionReference(
            path = "Loaders/text/x-prepro/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.OpenAction"),
            position = 100,
            separatorAfter = 200
    )
    ,
    @ActionReference(
            path = "Loaders/text/x-prepro/Actions",
            id = @ActionID(category = "Edit", id = "org.openide.actions.CutAction"),
            position = 300
    )
    ,
    @ActionReference(
            path = "Loaders/text/x-prepro/Actions",
            id = @ActionID(category = "Edit", id = "org.openide.actions.CopyAction"),
            position = 400,
            separatorAfter = 500
    )
    ,
    @ActionReference(
            path = "Loaders/text/x-prepro/Actions",
            id = @ActionID(category = "Edit", id = "org.openide.actions.DeleteAction"),
            position = 600
    )
    ,
    @ActionReference(
            path = "Loaders/text/x-prepro/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.RenameAction"),
            position = 700,
            separatorAfter = 800
    )
    ,
    @ActionReference(
            path = "Loaders/text/x-prepro/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.SaveAsTemplateAction"),
            position = 900,
            separatorAfter = 1000
    )
    ,
    @ActionReference(
            path = "Loaders/text/x-prepro/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.FileSystemAction"),
            position = 1100,
            separatorAfter = 1200
    )
    ,
    @ActionReference(
            path = "Loaders/text/x-prepro/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.ToolsAction"),
            position = 1300
    )
    ,
    @ActionReference(
            path = "Loaders/text/x-prepro/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.PropertiesAction"),
            position = 1400
    )
})
public class PreProDataObject extends MultiDataObject {

    public PreProDataObject(FileObject pf, MultiFileLoader loader) throws DataObjectExistsException, IOException {
        super(pf, loader);
        registerEditor("text/x-prepro", false);
    }

    @Override
    protected int associateLookup() {
        return 1;
    }

}
