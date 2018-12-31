package de.sbernauer.prepro.plugin.syntaxhighlighting.syntaxerror;

import java.util.Collection;
import java.util.Collections;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.spi.SchedulerTask;
import org.netbeans.modules.parsing.spi.TaskFactory;

@MimeRegistration(mimeType = "text/x-prepro", service = TaskFactory.class)
public class SyntaxErrorsHighlightingTaskFactory extends TaskFactory {

    public Collection<? extends SchedulerTask> create(Snapshot snapshot) {
        return Collections.singleton(new SyntaxErrorsHighlightingTask());
    }
}
