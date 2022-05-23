package com.example.myapplication;

import android.app.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class LoginedActivity extends Activity {
 //   String URL = "http://192.168.1.106:8080/AndroidProject/music/music_info.json";
    String URL = "";
    private TextView is_PlayTxt;
    private ImageButton playBtn, pre_Play_Btn, next_Play_Btn;
    private int is_Playing_Index;
    Intent intent;
    boolean playFlag = true, playStartFlag = false;
    ListView songList;
    private LinearLayout mainPageLayout, controlLayout;
    //  private float touchDownX, touchUpX;

    // String[] songNames = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
    //  String[] singers = {"dd", "d", "dd", "ddd"};
    ArrayList<HashMap<String, String>> playSongList = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String, String>> collectionSongArrayList = new ArrayList<HashMap<String, String>>();
    LinkedHashSet<HashMap<String, String>> collectSongFile = new LinkedHashSet<>();

    ImageButton playPageBtn, personPageBtn;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logined);
        SharedPreferences ipSP=getSharedPreferences("IP_FILE",Context.MODE_PRIVATE);
        URL="http://"+ipSP.getString("IP_Address","")+":8080/AndroidProject/music/music_info.json";
        //歌曲信息获取
        getSongsJsonArray();
//        System.out.println("5");
//        System.out.println(songsJSONArray);
        //account
        TextView account = findViewById(R.id.account);
        ImageButton personalInformationEdit = findViewById(R.id.PersonalInformationEdit);
        Bundle bundle = this.getIntent().getExtras();
        account.setText(bundle.getString("account"));
//List
        intent = new Intent(LoginedActivity.this, PlayMusic.class);

        controlLayout = findViewById(R.id.controlLayout);
        songList = findViewById(R.id.SongList);
        //header
        TextView header = new TextView(this);
        header.setText(R.string.musicList);
        header.setTextSize(22);
        header.setPaddingRelative(0, 40, 0, 40);
        songList.addHeaderView(header);
//foot
//        TextView foot=new TextView(this);
//        foot.setText("请选择");
//        foot.setTextSize(28);
//        songList.addFooterView(foot);

        //  songList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, songNames));


        songList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // System.out.println(songNames[position - 1]);
                //stop
                playBtn.setImageResource(android.R.drawable.ic_media_play);
                LoginedActivity.this.stopService(intent);
                playFlag = true;

                //  Toast.makeText(LoginedActivity.this, "OK" + ((TextView) view).getText(), Toast.LENGTH_LONG).show();

                Bundle bundleMusicName = new Bundle();
                // bundleMusicName.putString("songName", songNames[position - 1]);
                is_Playing_Index = position - 1;
                bundleMusicName.putString("songName", playSongList.get(position - 1).get("songName"));
                intent.putExtras(bundleMusicName);
                //start
                playBtn.setImageResource(android.R.drawable.ic_media_pause);
                LoginedActivity.this.startService(intent);
                is_PlayTxt.setText(playSongList.get(position - 1).get("songName"));
                playStartFlag = true;
                playFlag = false;
            }
        });
        songList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginedActivity.this);
                builder.setMessage("添加到我的收藏");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        HashMap<String, String> temp = new HashMap<>();
                        temp.put("songName", (((TextView) view.findViewById(R.id.SongName)).getText().toString()));
                        temp.put("singer", ((TextView) view.findViewById(R.id.Singer)).getText().toString());
//                        collectionSongArrayList.add(temp);
                        if (!collectSongFile.contains(temp)) {
                            collectSongFile.add(temp);
                            SharedPreferences sp = getSharedPreferences("My_Collection_Song_FILE", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putInt("line_num", 2 * collectSongFile.size());
                            editor.putString("Status_" + (2 * collectSongFile.size() - 2), temp.get("songName"));
                            editor.putString("Status_" + (2 * collectSongFile.size() - 1), temp.get("singer"));
                            editor.commit();
                        }
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
                return true;
            }
        });

        //   songList.setOnTouchListener(new ChangePageOnClickListener());

        //is_Playing
        is_PlayTxt = findViewById(R.id.Is_Playing);
        //pre_next
        next_Play_Btn = findViewById(R.id.Next_Song_Btn);
        next_Play_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (is_Playing_Index >= playSongList.size() - 1) {
                    Toast.makeText(LoginedActivity.this, "已经是最后一首", Toast.LENGTH_LONG).show();
                } else {
                    LoginedActivity.this.stopService(intent);
                    Bundle bundleMusicName = new Bundle();
                    // bundleMusicName.putString("songName", songNames[position - 1]);
                    bundleMusicName.putString("songName", playSongList.get(is_Playing_Index + 1).get("songName"));
                    intent.putExtras(bundleMusicName);
                    //start
                    playBtn.setImageResource(android.R.drawable.ic_media_pause);
                    LoginedActivity.this.startService(intent);
                    is_PlayTxt.setText(playSongList.get(is_Playing_Index + 1).get("songName"));
                    if (is_Playing_Index < playSongList.size() - 1) {
                        is_Playing_Index++;
                    }
                    playStartFlag = true;
                    playFlag = false;
                }
            }
        });
        pre_Play_Btn = findViewById(R.id.Pre_Song_Btn);
        pre_Play_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (is_Playing_Index <= 0) {
                    Toast.makeText(LoginedActivity.this, "已经是第一首", Toast.LENGTH_LONG).show();
                } else {
                    LoginedActivity.this.stopService(intent);
                    Bundle bundleMusicName = new Bundle();
                    // bundleMusicName.putString("songName", songNames[position - 1]);
                    bundleMusicName.putString("songName", playSongList.get(is_Playing_Index - 1).get("songName"));
                    intent.putExtras(bundleMusicName);
                    //start
                    playBtn.setImageResource(android.R.drawable.ic_media_pause);
                    LoginedActivity.this.startService(intent);
                    is_PlayTxt.setText(playSongList.get(is_Playing_Index - 1).get("songName"));
                    if (is_Playing_Index > 0) {
                        is_Playing_Index--;
                    }
                    playStartFlag = true;
                    playFlag = false;
                }
            }
        });

        //play
        playBtn = findViewById(R.id.PlayMusic);
        playBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (playFlag) {
                    if (playStartFlag == false) {
                        Toast.makeText(LoginedActivity.this, "请选择歌曲", Toast.LENGTH_LONG).show();
                    } else {
                        playBtn.setImageResource(android.R.drawable.ic_media_pause);
                        LoginedActivity.this.startService(intent);
                        playFlag = false;
                    }
                } else {
                    playBtn.setImageResource(android.R.drawable.ic_media_play);
                    LoginedActivity.this.stopService(intent);
                    playFlag = true;
                }
            }
        });
        //
        mainPageLayout = findViewById(R.id.mainPage);
        //   mainPageLayout.setOnTouchListener(new ChangePageOnClickListener());
        //底部按钮切换
        playPageBtn = findViewById(R.id.playPage);
        playPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPlayPage();
            }
        });
        personPageBtn = findViewById(R.id.personPage);
        personPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCollectionPage();
            }
        });
        SharedPreferences sp = getSharedPreferences("My_Collection_Song_FILE", Context.MODE_PRIVATE);
        for (int i = 0; i < sp.getInt("line_num", 0); i += 2) {
            HashMap<String, String> temp = new HashMap<String, String>();
            temp.put("songName", sp.getString("Status_" + i, ""));
            temp.put("singer", sp.getString("Status_" + (i + 1), ""));
            collectSongFile.add(temp);
        }
    }


    private void getSongsJsonArray() {
        RequestQueue queue = Volley.newRequestQueue(LoginedActivity.this);

        JsonArrayRequest songsJsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        //    songNames[i] = response.getJSONObject(i).getString("songName");
                        HashMap temp = new HashMap();
                        temp.put("songName", response.getJSONObject(i).getString("songName"));
                        temp.put("singer", response.getJSONObject(i).getString("singer"));
                        playSongList.add(temp);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //songList.setAdapter(new ArrayAdapter<String>(LoginedActivity.this, android.R.layout.simple_list_item_1, songNames));
                String[] keys = {"songName", "singer"};
                // int[] ids = {android.R.id.text1, android.R.id.text2};
                int[] ids = {R.id.SongName, R.id.Singer};
                //   songList.setAdapter(new SimpleAdapter(LoginedActivity.this, playSongList, android.R.layout.simple_list_item_2, keys, ids));
                songList.setAdapter(new SimpleAdapter(LoginedActivity.this, playSongList, R.layout.song_text, keys, ids));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
                try {
                    JSONArray jsonArray = new JSONArray(new String(response.data, "UTF-8"));
                    return Response.success(jsonArray, HttpHeaderParser.parseCacheHeaders(response));
                } catch (JSONException e) {
                    e.printStackTrace();
                    return Response.error(new ParseError(e));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return Response.error(new ParseError(e));
                }
//                return super.parseNetworkResponse(response);
            }
        };
        queue.add(songsJsonArrayRequest);
    }

//和OnItemClickListener冲突，放弃
//    class ChangePageOnClickListener implements View.OnTouchListener {
//        @Override
//        public boolean onTouch(View v, MotionEvent event) {
//
//            if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                touchDownX = event.getX();
//                return true;
//            } else if (event.getAction() == MotionEvent.ACTION_UP) {
//                touchUpX = event.getX();
//                if (touchUpX - touchDownX > 100) {
//                    setPlayPage();
//                } else if (touchDownX - touchUpX > 100) {
//                    setCollectionPage();
//                }
//                return true;
//            }
//            return false;
//        }
//    }

    private void setPlayPage() {
        playPageBtn.setImageResource(R.drawable.music_light);
        personPageBtn.setImageResource(R.drawable.collection_dark);
        mainPageLayout.removeAllViewsInLayout();
        mainPageLayout.addView(songList);
        mainPageLayout.addView(controlLayout);
    }

    private void setCollectionPage() {
        playPageBtn.setImageResource(R.drawable.music_dark);
        personPageBtn.setImageResource(R.drawable.collection_light);
        mainPageLayout.removeAllViewsInLayout();
        ListView collectionSongsList = new ListView(LoginedActivity.this);
        TextView collectionSongsListHeader = new TextView(LoginedActivity.this);
        collectionSongsListHeader.setText(R.string.myCollection);
        collectionSongsListHeader.setTextSize(22);
        collectionSongsListHeader.setPaddingRelative(0, 40, 0, 40);
        collectionSongsList.addHeaderView(collectionSongsListHeader);
//        String[] collectionSongs = {
//                "test",
//                "test"
//        };
        collectionSongsList.setPaddingRelative(50, 0, 0, 0);
        //   collectionSongsList.setAdapter(new ArrayAdapter<String>(LoginedActivity.this, android.R.layout.simple_list_item_1, collectionSongs));
//        ArrayList<HashMap<String, String>> collectionSongArrayList = new ArrayList<HashMap<String, String>>();
//        HashMap<String, String> temp = new HashMap<>();
//        temp.put("songName", "test1");
//        temp.put("singer", "singer1");
//        collectionSongArrayList.add(temp);
//        collectionSongArrayList.removeAll(collectionSongArrayList);
//        SharedPreferences sp=getSharedPreferences("My_Collection_Song_FILE",Context.MODE_PRIVATE);
//        for (int i=0;i<sp.getInt("line_num",0);i+=2){
//            HashMap<String,String> temp=new HashMap<String,String>();
//            temp.put("songName",sp.getString("Status_"+i,""));
//            temp.put("singer",sp.getString("Status_"+(i+1),""));
//            collectionSongArrayList.add(temp);
//        }
        collectionSongArrayList = new ArrayList<HashMap<String, String>>(collectSongFile);

        String[] keys = {"songName", "singer"};
        int[] ids = {R.id.SongName, R.id.Singer};
        collectionSongsList.setAdapter(new SimpleAdapter(LoginedActivity.this, collectionSongArrayList, R.layout.song_text, keys, ids));

        collectionSongsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(LoginedActivity.this, "test", Toast.LENGTH_LONG).show();
            }
        });
        mainPageLayout.addView(collectionSongsList);
        //   collectionSongsList.setOnTouchListener(new ChangePageOnClickListener());
        collectionSongsList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginedActivity.this);
                builder.setMessage("取消收藏");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences sp = getSharedPreferences("My_Collection_Song_FILE", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.clear();
                        editor.commit();
                        HashMap<String, String> temp = new HashMap<>();
                        temp.put("songName", ((TextView) view.findViewById(R.id.SongName)).getText().toString());
                        temp.put("singer", ((TextView) view.findViewById(R.id.Singer)).getText().toString());
                        collectSongFile.remove(temp);
                        editor.putInt("line_num", 2 * collectSongFile.size());
                        int n = 0;
                        for (HashMap<String, String> i : collectSongFile) {
                            editor.putString("Status_" + n, i.get("songName"));
                            editor.putString("Status_" + (n + 1), i.get("singer"));
                            n += 2;
                        }
                        editor.commit();
                        dialog.dismiss();
                        setCollectionPage();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
                return true;
            }
        });
    }

}