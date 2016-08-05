package com.malikov;

import com.malikov.model.User;
import org.displaytag.decorator.TableDecorator;

public class TableWrapper extends TableDecorator {
    public TableWrapper() {
        super();
    }

    public String getLinkEdit() {
        User lObject = (User) getCurrentRowObject();
        int lId = lObject.getId();

        return "<a href=\"" + "edit/" + lId + "\">Edit</a>";
    }

    public String getLinkDelete() {
        User lObject = (User) getCurrentRowObject();
        int lId = lObject.getId();

        return "<a href=\"" + "remove/" + lId + "\">Delete</a>";
    }

}