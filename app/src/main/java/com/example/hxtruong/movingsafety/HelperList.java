package com.example.hxtruong.movingsafety;

import android.location.Location;

import com.google.android.gms.maps.GoogleMap;

import java.util.ArrayList;

public class HelperList {
    private static GoogleMap mMap;
    private ArrayList<Helper> helperArrayList;

    // make array helper
    public HelperList(GoogleMap map) {
        this.mMap = map;
        this.helperArrayList = new ArrayList<Helper>();

        spawnRandomHelper();
    }

    private void spawnRandomHelper() {
        Location pivotLoc = mMap.getMyLocation();
        // 1
        Location loc = new Location("1");
        loc.setLatitude(mMap.getMyLocation().getLatitude() + Math.random() * 0.01);
        loc.setLongitude(mMap.getMyLocation().getLongitude() + Math.random() * 0.01);
        Helper helper = new Helper("Tiệm sửa xe Thắng Hòa", loc,
                "86/6 Đường 16, Khu phố 8, Phường Bình Hưng Hòa A, Quận Bình Tân, TP Hồ Chí Minh",
                "0986241241",
                "h1");
        this.helperArrayList.add(helper);

        // 2
        loc = new Location("2");
        loc.setLatitude(pivotLoc.getLatitude() - Math.random() * 0.01);
        loc.setLongitude(pivotLoc.getLongitude() + Math.random() * 0.01);
        helper = new Helper("Tiệm sửa xe Hòa Lộc", loc,
                "Số 1072 QL 22 , ấp Mây Đắng, Xã Phước Thạnh, Huyện Củ Chi, TP Hồ Chí Minh",
                "0124524624",
                "h2");
        this.helperArrayList.add(helper);

        // 3
        loc = new Location("3");
        loc.setLatitude(pivotLoc.getLatitude() + Math.random() * 0.01);
        loc.setLongitude(pivotLoc.getLongitude() - Math.random() * 0.01);
        helper = new Helper("Tiệm Honda Phát Tài", loc,
                "198/50 ĐOàN VăN Bơ, phường 09, Quận 4, TP Hồ Chí Minh",
                "01882451247",
                "h3");
        this.helperArrayList.add(helper);

        // 4
        loc = new Location("4");
        loc.setLatitude(pivotLoc.getLatitude() + Math.random() * 0.1);
        loc.setLongitude(pivotLoc.getLongitude() + Math.random() * 0.1);
        helper = new Helper("Tiệm Shuduki TẤN", loc,
                "126/5G, ấp Tam Đông 3, Xã Thới Tam Thôn, Huyện Hóc Môn, TP Hồ Chí Minh",
                "0974251425",
                "h4");
        this.helperArrayList.add(helper);

        // 5
        loc = new Location("5");
        loc.setLatitude(pivotLoc.getLatitude() - Math.random() * 0.01);
        loc.setLongitude(pivotLoc.getLongitude() - Math.random() * 0.01);
        helper = new Helper("Sửa xe Trí đầu hói", loc,
                "50/57/18 Phú Định, Phường 16, Quận 8, TP Hồ Chí Minh",
                "01324521458",
                "h5");
        this.helperArrayList.add(helper);

        // 6
        loc = new Location("6");
        loc.setLatitude(pivotLoc.getLatitude() + Math.random() * 0.01);
        loc.setLongitude(pivotLoc.getLongitude() - Math.random() * 0.01);
        helper = new Helper("Trung tâm sửa chữa xe máy Long ca ca", loc,
                "1313 Tỉnh Lộ 10, Khu phố 3, Phường Tân Tạo A, Quận Bình Tân, TP Hồ Chí Minh",
                "0163542147",
                "h6");
        this.helperArrayList.add(helper);

        // 7
        loc = new Location("7");
        loc.setLatitude(pivotLoc.getLatitude() + Math.random() * 0.01);
        loc.setLongitude(pivotLoc.getLongitude() + Math.random() * 0.01);
        helper = new Helper("Gara Minh Thiết Công", loc,
                "Số 11 Đường Nội Khu Hưng Phước 2, Phường Tân Phong, Quận 7, TP Hồ Chí Minh",
                "0654285214",
                "h7");
        this.helperArrayList.add(helper);
    }

    public void displayAllHelperMarker() {
        for (Helper e : helperArrayList) {
            e.addMarker(mMap);
        }
    }

    public int getSizeList() {
        return helperArrayList.size();
    }

    public Helper getHelper(int i) {
        return helperArrayList.get(i);
    }

    public void updateDistanceCurrentLocation(Location currentLocation) {
        for (Helper e : helperArrayList) {
            e.updateDistanceToCurrentLocation(currentLocation);
        }
    }
}
