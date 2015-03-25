package cn.hubery.commservice.util;

/**
 * 各个链接的URL
 * 
 * @author 24K
 * @created 2014年2月24日17:18:15
 */
public class UrlUtils {

	public static String IP = "http://192.168.11.65";
	public static String PORT = ":8080";

	/** 登录 */
	public static String loginURL = IP + PORT + "/wy/api/login.action";
	/** 物业列表 --中间list*/
	public static String pmpenyListURL = IP + PORT + "/wy/api/pmpenyList.action";
	/** 查询选项--right */
	public static String intoQueryURL = IP + PORT + "/wy/api/intoQuery.action";
	/** 物业查看--点击进入详情 */
	public static String intoPmpenyViewURL = IP + PORT + "/wy/api/intoPmpenyView.action";
	/**楼层*/
	public static String floorListURL = IP + PORT + "/wy/api/floorList.action";
	/**楼层内部界面*/
	public static String intoFloorViewURL = IP + PORT + "/wy/api/intoFloorView.action";
	/**房间列表*/
	public static String roomListURL = IP + PORT + "/wy/api/roomList.action";
	/**房间详情*/
	public static String intoRoomViewURL = IP + PORT + "/wy/api/intoRoomView.action";
	/**采集列表*/
	public static String collectListURL = IP + PORT + "/wy/api/collectList.action";
	/**采集详情*/
	public static String intoCollectViewURL = IP + PORT + "/wy/api/intoCollectView.action";

	/**大楼信息编辑*/
	public static String submitPmpenyEdit = IP + PORT + "/wy/api/submitPmpenyEdit.action";
	public static final String GEOCODE_LATLNG_URL = "http://maps.google.com/maps/api/geocode/json?latlng=%s&sensor=true&language=%s";
	/**组织框架*/
	public static String intoDepTree = IP + PORT + "/wy/api/intoDepTree.action";
 
	
	/**进入楼层新增*/
	public static String intoFloorAdd = IP + PORT + "/wy/api/intoFloorAdd.action";
	/**提交楼层新增*/
	public static String submitFloorAdd = IP + PORT + "/wy/api/submitFloorAdd.action";
	/**楼层编辑*/
	public static String submitFloorEdit = IP + PORT + "/wy/api/submitFloorEdit.action";
	
	/**所有房间编辑*/
	public static String intoRoomEdit = IP + PORT + "/wy/api/intoRoomEdit.action";
	/**进入新增*/
	public static String intoRoomAdd = IP + PORT + "/wy/api/intoRoomAdd.action";
	/**提交新增房间*/
	public static String submitRoomAdd = IP + PORT + "/wy/api/submitRoomAdd.action";
	/**提交修改某个房间*/
	public static String submitRoomEdit = IP + PORT + "/wy/api/submitRoomEdit.action";
	
	public static String deletePmpeny= IP + PORT + "/wy/api/deletePmpeny.action";
	public static String deleteFloor= IP + PORT + "/wy/api/deleteFloor.action";
	public static String deleteRoom= IP + PORT + "/wy/api/deleteRoom.action";
 
	
 
}
