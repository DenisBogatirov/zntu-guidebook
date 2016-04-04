package ua.edu.zntu.guidebook.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.LinkedList;

import ua.edu.zntu.guidebook.R;
import ua.edu.zntu.guidebook.adapters.LessonAdapter;
import ua.edu.zntu.guidebook.adapters.SectionAdapter;
import ua.edu.zntu.guidebook.async.TimetableAsyncTask;
import ua.edu.zntu.guidebook.pojo.Section;

public class GuidebookFragment extends Fragment{

    public static final String TAG = "GuideBookFragmentTag";
    private static final int LAYOUT = R.layout.guidebook_layout;

    private View view;
    private TimetableAsyncTask asyncTask;
    private Context context;
    private LinkedList<Section> sections = new LinkedList<>();

    private static ListView sectionListView;
    private static SectionAdapter sectionAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(LAYOUT, container, false);
        context = getContext();

        sections.clear();



        Section.Builder builder = new Section.Builder();
        Section tmp;
        int counter = 0;

        try {
            XmlPullParser xpp = prepareXpp();

            while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
                switch (xpp.getEventType()) {
                    // начало тэга
                    case XmlPullParser.START_TAG:
                        if (!xpp.getName().equals("guidebook") && !xpp.getName().equals("section")){
                            if(xpp.getName().equals("title")){
                                xpp.next();
                                builder.setTitle(xpp.getText());
                            }
                        }

                        break;
                    // конец тэга
                    case XmlPullParser.END_TAG:
                        if(xpp.getName().equals("section"))
                        {
                            builder.setId(counter);
                            tmp = builder.build();
                            sections.add(tmp);
                            counter++;
                        }
                        break;
                    default:
                        break;
                }
                // следующий элемент
                xpp.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sectionAdapter = new SectionAdapter(sections, context);
        sectionListView = (ListView) view.findViewById(R.id.guidebook_listView);
        sectionListView.setAdapter(sectionAdapter);

        Log.d("MyTAG", String.valueOf(sections.size()));

        return view;
    }

    XmlPullParser prepareXpp() {
        return getResources().getXml(R.xml.guidebook);
    }
}
