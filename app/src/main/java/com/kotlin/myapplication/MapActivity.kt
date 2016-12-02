package com.kotlin.myapplication
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.baidu.mapapi.map.*
import com.baidu.mapapi.model.LatLng
import kotlinx.android.synthetic.main.activity_map.*
class MapActivity : AppCompatActivity() {
    internal var mBaiduMap: BaiduMap? = null
    private var mMarker: Marker? = null
    private var mInfoWindow: InfoWindow? = null
    override fun onCreate(arg0: Bundle?) {
        super.onCreate(arg0)
        setContentView(R.layout.activity_map)
        initViews()
    }

    fun initViews() {
        // 地图初始化
        mBaiduMap = mMapView.map
        mBaiduMap!!.setMapStatus(MapStatusUpdateFactory.zoomTo(20.0f))
        val result = LatLng(34.827503, 113.549977)
        mMarker = mBaiduMap!!.addOverlay(MarkerOptions().position(result)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_gcoding))) as Marker
        mBaiduMap!!.setMapStatus(MapStatusUpdateFactory.newLatLng(result))
        val location = TextView(this@MapActivity)
        location.setBackgroundResource(R.mipmap.popup)
        location.setPadding(30, 20, 30, 50)
        location.setTextColor(resources.getColor(R.color.text_color1))
        location.text = "郑州大学盛和苑"
        mInfoWindow = InfoWindow(location, mMarker!!.position, -87)
        mBaiduMap!!.setOnMarkerClickListener {
            mBaiduMap!!.showInfoWindow(mInfoWindow)
            true
        }
        mBaiduMap!!.setOnMapClickListener(object : BaiduMap.OnMapClickListener {
            override fun onMapClick(latLng: LatLng) {
                mBaiduMap!!.hideInfoWindow()
            }
            override fun onMapPoiClick(mapPoi: MapPoi): Boolean {
                return false
            }
        })

    }

    override fun onPause() {
        mMapView!!.onPause()
        super.onPause()
    }

    override fun onResume() {
        mMapView!!.onResume()
        super.onResume()
    }

    override fun onDestroy() {
        mMapView!!.onDestroy()
        super.onDestroy()
    }
}
