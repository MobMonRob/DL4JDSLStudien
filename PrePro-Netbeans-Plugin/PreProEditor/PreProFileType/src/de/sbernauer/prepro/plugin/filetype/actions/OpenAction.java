package org.demo.cminus.filetype.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.cookies.EditorCookie;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "org.demo.cminus.filetype.actions.OpenAction"
)
@ActionRegistration(
        displayName = "#CTL_OpenAction"
)
@ActionReference(path = "Menu/File", position = 1300)
@Messages("CTL_OpenAction=Open PrePro-File")
public final class OpenAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            File file = new File("/home/sbernauer/Downloads/test.prepro");
            FileObject foSelectedFile = FileUtil.toFileObject(file);
            
            DataObject obj = DataObject.find(foSelectedFile);
            EditorCookie ec = obj.getLookup().lookup(EditorCookie.class);
            
            if (ec != null) {
                ec.open();
            }
        } catch (DataObjectNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        }

    }
}
