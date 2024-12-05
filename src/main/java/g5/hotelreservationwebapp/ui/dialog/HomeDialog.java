package g5.hotelreservationwebapp.ui.dialog;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.router.Route;

@Route("home-dialog")
public class HomeDialog extends VerticalLayout {

    public HomeDialog() {
        String messageForConstructionDialog = """
                Hi! Click the menu drawer to get started!
                """;
        addParagraphToLayout(messageForConstructionDialog);

    }

    private void addProgressBarToLayout(Double progress) {
        ProgressBar progressBar = new ProgressBar();
        progressBar.setValue(progress);
        add(progressBar);
    }

    private void addParagraphToLayout(String text) {
        Paragraph paragraph = new Paragraph(text);
        paragraph.getStyle().set("white-space", "pre-line");
        add(paragraph);
    }
}
