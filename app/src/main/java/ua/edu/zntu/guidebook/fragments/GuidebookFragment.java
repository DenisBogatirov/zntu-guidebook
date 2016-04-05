package ua.edu.zntu.guidebook.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.LinkedList;

import ua.edu.zntu.guidebook.R;
import ua.edu.zntu.guidebook.adapters.SectionAdapter;
import ua.edu.zntu.guidebook.pojo.Person;
import ua.edu.zntu.guidebook.pojo.Section;

public class GuidebookFragment extends Fragment{

    public static final String TAG = "GuideBookFragmentTag";
    private static final int LAYOUT = R.layout.guidebook_layout;

//    private

    private View view;
    private Context context;
    private LinkedList<Section> sections = new LinkedList<>();

    private static ListView sectionListView;
    private static SectionAdapter sectionAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(LAYOUT, container, false);
        context = getContext();

        sections.clear();



        Section.Builder sectionBuilder = new Section.Builder();
        Person.Builder personBuilder = new Person.Builder();
        LinkedList<Person> tmpPersons = new LinkedList<>();
        Section tmpSection;
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
                                sectionBuilder.setTitle(xpp.getText());
                            }
                            else if (xpp.getName().equals("job")) {
                                xpp.next();
                                personBuilder.setJob(xpp.getText());
                            }
                            else if (xpp.getName().equals("name")) {
                                xpp.next();
                                personBuilder.setName(xpp.getText());
                            }
                            else if (xpp.getName().equals("phone")) {
                                xpp.next();
                                personBuilder.setPhone(xpp.getText());
                            }
                            else if (xpp.getName().equals("vk")) {
                                xpp.next();
                                personBuilder.setVk(xpp.getText());
                            }
                            else if (xpp.getName().equals("additional")) {
                                xpp.next();
                                personBuilder.setAdditional(xpp.getText());
                            }
                        }

                        break;
                    // конец тэга
                    case XmlPullParser.END_TAG:
                        if(xpp.getName().equals("section"))
                        {
                            sectionBuilder.setId(counter)
                                    .setPersons((LinkedList<Person>) tmpPersons.clone());
                            sections.add(sectionBuilder.build());
                            tmpPersons.clear();
                            counter++;
                        }
                        else if (xpp.getName().equals("person")) {
                            tmpPersons.add(personBuilder.build());
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

        sectionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("Section", sections.get(position));
                SectionInfoFragment sectionInfoFragment = new SectionInfoFragment();
                sectionInfoFragment.setArguments(bundle);

                final FragmentManager manager = getFragmentManager();
                final FragmentTransaction transaction = manager.beginTransaction();



                if (manager.findFragmentByTag(GuidebookFragment.TAG) != null){
                    transaction.replace(R.id.container, sectionInfoFragment, SectionInfoFragment.TAG);
                }
                else if (manager.findFragmentByTag(SectionInfoFragment.TAG) == null) {
                    transaction.add(R.id.container, sectionInfoFragment, SectionInfoFragment.TAG);
                }

                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }

    XmlPullParser prepareXpp() {
        return getResources().getXml(R.xml.guidebook);
    }
}
