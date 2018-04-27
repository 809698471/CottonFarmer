package com.lianghuawang.cottonfarmer.entity.db.personalInform;

import com.lianghuawang.cottonfarmer.ui.base.BaseDB;

import java.util.List;

/**
 * 个人信息---基本信息
 * 头像
 * 姓名
 * 性别
 * 民族
 * 身份证
 * 联系方式
 * 家庭住址
 * 邮编
 * 农作物类型
 * 种植面积
 * 种植地址
 * 地块数量
 * 地块信息
 * 近3年平均产量
 * 权属证明
 */
public class BasicInformDBDB extends BaseDB{

    private int id;
    private String headLocalPath;//头像本地地址
    private String headNetworkPath;//头像网络地址
    private int userId;
    private String userName;//姓名
    private int gender;//性别：0男，1女
    private String national;//民族
    private String idCard;//身份证
    private String telePhone;//联系方式
    private String address;//家庭住址
    private String ZipCode;//邮编
    private int cropsType;//农作物类型（例如：0棉花；1稻谷；2麦子；3小米）
    private float plantingArea;//种植面积
    private String plantingAddressType;//种植地址
    private int blockNumber;//地块数量
    private List<Block> block;//地块信息
    private float averageProduction;//近3年平均产量
    private List<Ownership> ownerships;//权属证明

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeadLocalPath() {
        return headLocalPath;
    }

    public void setHeadLocalPath(String headLocalPath) {
        this.headLocalPath = headLocalPath;
    }

    public String getHeadNetworkPath() {
        return headNetworkPath;
    }

    public void setHeadNetworkPath(String headNetworkPath) {
        this.headNetworkPath = headNetworkPath;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTelePhone() {
        return telePhone;
    }

    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }

    public int getCropsType() {
        return cropsType;
    }

    public void setCropsType(int cropsType) {
        this.cropsType = cropsType;
    }

    public float getPlantingArea() {
        return plantingArea;
    }

    public void setPlantingArea(float plantingArea) {
        this.plantingArea = plantingArea;
    }

    public String getPlantingAddressType() {
        return plantingAddressType;
    }

    public void setPlantingAddressType(String plantingAddressType) {
        this.plantingAddressType = plantingAddressType;
    }

    public int getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(int blockNumber) {
        this.blockNumber = blockNumber;
    }

    public List<Block> getBlock() {
        return block;
    }

    public void setBlock(List<Block> block) {
        this.block = block;
    }

    public float getAverageProduction() {
        return averageProduction;
    }

    public void setAverageProduction(float averageProduction) {
        this.averageProduction = averageProduction;
    }

    public List<Ownership> getOwnerships() {
        return ownerships;
    }

    public void setOwnerships(List<Ownership> ownerships) {
        this.ownerships = ownerships;
    }

    private class Block{

        private int id;
        private int blockId;//地块ID
        private String blockName;//地块俗称
        private float longitude;//经度
        private float latitude;//纬度

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getBlockId() {
            return blockId;
        }

        public void setBlockId(int blockId) {
            this.blockId = blockId;
        }

        public String getBlockName() {
            return blockName;
        }

        public void setBlockName(String blockName) {
            this.blockName = blockName;
        }

        public float getLongitude() {
            return longitude;
        }

        public void setLongitude(float longitude) {
            this.longitude = longitude;
        }

        public float getLatitude() {
            return latitude;
        }

        public void setLatitude(float latitude) {
            this.latitude = latitude;
        }

        @Override
        public String toString() {
            return "Block{" +
                    "blockId=" + blockId +
                    ", blockName='" + blockName + '\'' +
                    ", longitude=" + longitude +
                    ", latitude=" + latitude +
                    '}';
        }
    }

    private class Ownership{
        private int OwnershipId;
        private int id;
        private String ownershipLoaclPath;
        private String ownershipNetworkPath;

        public int getOwnershipId() {
            return OwnershipId;
        }

        public void setOwnershipId(int ownershipId) {
            OwnershipId = ownershipId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOwnershipLoaclPath() {
            return ownershipLoaclPath;
        }

        public void setOwnershipLoaclPath(String ownershipLoaclPath) {
            this.ownershipLoaclPath = ownershipLoaclPath;
        }

        public String getOwnershipNetworkPath() {
            return ownershipNetworkPath;
        }

        public void setOwnershipNetworkPath(String ownershipNetworkPath) {
            this.ownershipNetworkPath = ownershipNetworkPath;
        }

        @Override
        public String toString() {
            return "Ownership{" +
                    "OwnershipId=" + OwnershipId +
                    ", id=" + id +
                    ", ownershipLoaclPath='" + ownershipLoaclPath + '\'' +
                    ", ownershipNetworkPath='" + ownershipNetworkPath + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "BasicInformDBDB{" +
                "id=" + id +
                ", headLocalPath='" + headLocalPath + '\'' +
                ", headNetworkPath='" + headNetworkPath + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", gender=" + gender +
                ", national='" + national + '\'' +
                ", idCard='" + idCard + '\'' +
                ", telePhone='" + telePhone + '\'' +
                ", address='" + address + '\'' +
                ", ZipCode='" + ZipCode + '\'' +
                ", cropsType=" + cropsType +
                ", plantingArea=" + plantingArea +
                ", plantingAddressType='" + plantingAddressType + '\'' +
                ", blockNumber=" + blockNumber +
                ", block=" + block +
                ", averageProduction=" + averageProduction +
                ", ownerships=" + ownerships +
                '}';
    }
}
