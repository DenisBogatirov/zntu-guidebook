package ua.edu.zntu.guidebook.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.HashMap;

import ua.edu.zntu.guidebook.R;
import ua.edu.zntu.guidebook.pojo.Room;

public class RoomsFragment extends Fragment {

    public static final String TAG = "RoomsFragmentTag";
    private static final int LAYOUT = R.layout.rooms_layout;

    private View view;
    private Room tmp;
    private HashMap<String, Room> rooms = new HashMap<>();

    private EditText editText;
    private TextView tv_title;
    private TextView tv_housing;
    private TextView tv_floor;
    private TextView tv_description;
    private Button btnFind;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(LAYOUT, container, false);

        editText = (EditText) view.findViewById(R.id.editText);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_housing = (TextView) view.findViewById(R.id.tv_housing);
        tv_floor = (TextView) view.findViewById(R.id.tv_floor);
        tv_description = (TextView) view.findViewById(R.id.tv_description);
        btnFind = (Button) view.findViewById(R.id.btn_find);

        long start = System.currentTimeMillis();

        Room.Builder builder = new Room.Builder();

        try {
            XmlPullParser xpp = prepareXpp();

            while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
                switch (xpp.getEventType()) {
                    // начало тэга
                    case XmlPullParser.START_TAG:
                        if (!xpp.getName().equals("rooms") && !xpp.getName().equals("room")){
                            if(xpp.getName().equals("title")){
                                xpp.next();
                                builder.setTitle(xpp.getText());
                            }
                            else if(xpp.getName().equals("housing")){
                                xpp.next();
                                builder.setHousing(xpp.getText());
                            }
                            else if(xpp.getName().equals("floor")){
                                xpp.next();
                                builder.setFloor(xpp.getText());
                            }
                            else if(xpp.getName().equals("description")){
                                xpp.next();
                                builder.setDescription(xpp.getText());
                            }
                        }

                        break;
                    // конец тэга
                    case XmlPullParser.END_TAG:
                        if(xpp.getName().equals("room"))
                        {
                            tmp = builder.build();
                            rooms.put(tmp.getTitle(),tmp);
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

        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value;
                Room room;
                value = editText.getText().toString();
                if(rooms.containsKey(value))
                {
                    room = rooms.get(value);
                    tv_title.setText(room.getTitle());
                    tv_housing.setText(room.getHousing());
                    tv_floor.setText(room.getFloor());
                    tv_description.setText(room.getDescription());
                }
                else {
                    tv_title.setText("No such room");
                    tv_housing.setText("");
                    tv_housing.setText("");
                    tv_floor.setText("");
                    tv_description.setText("");

                }

                editText.getText().clear();
            }
        });

        return view;
    }

    XmlPullParser prepareXpp() {
        return getResources().getXml(R.xml.rooms);
    }

}
