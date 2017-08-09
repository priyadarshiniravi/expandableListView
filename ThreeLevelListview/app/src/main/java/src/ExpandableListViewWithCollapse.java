package src;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;

public class ExpandableListViewWithCollapse extends ExpandableListView {
    public ExpandableListViewWithCollapse(Context context) {
        super(context);
        setDivider(null);

        setOnClick();
    }

    public ExpandableListViewWithCollapse(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClick();
    }

    public ExpandableListViewWithCollapse(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setOnClick();
    }

    private void setOnClick() {
        setOnGroupClickListener(new OnGroupClickListener() {
            int previousGroup = -1;
            @Override
            public boolean onGroupClick(ExpandableListView parent, View view, int groupPosition, long l) {
                if (!isGroupExpanded(groupPosition)) {
                    expandWithAnimation(groupPosition);

                    if(previousGroup!=-1){
                        collapseGroup(previousGroup);
                    }
                    previousGroup=groupPosition;
                }
                return true;
            }
        });

    }

    private void expandWithAnimation(final int groupPosition) {
        expandGroup(groupPosition);
    }

}

