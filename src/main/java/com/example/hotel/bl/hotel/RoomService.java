package com.example.hotel.bl.hotel;

import com.example.hotel.po.HotelRoom;

import java.util.List;

public interface RoomService {

    /**
     * 获取某个酒店的全部房间信息
     * @param hotelId
     * @return
     */
    List<HotelRoom> retrieveHotelRoomInfo(Integer hotelId);

    /**
     * 添加酒店客房信息
     * @param hotelRoom
     */
    void insertRoomInfo(HotelRoom hotelRoom);

    /**
     * 预订酒店后更新客房房间数量
     * @param roomId
     * @param rooms
     */
    void updateRoomInfo(Integer roomId, Integer rooms);

    /**
     * 获取酒店指定房间剩余数量
     * @param roomId
     * @return
     */
    int getRoomCurNum(Integer roomId);

    /**
     * 更新酒店客房信息
     * @param hotelRoom
     */
    void editRoomInfo(HotelRoom hotelRoom);

    void deleteRoom(Integer roomId);
}
