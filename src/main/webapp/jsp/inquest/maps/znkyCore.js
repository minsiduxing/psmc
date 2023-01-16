/**
 * 测距(中小学距离测算)
 * @param newgridCaclMode
 */
function disCacl(newgridCaclMode){
    var ruleType = newgridCaclMode.RULE_TYPE;
    var tszbType;
    if(4 == ruleType){
         tszbType=1802;
    }
    if(5 == ruleType){
         tszbType=1801;
    }
        for(var x=0;x<regionCoordinateDatas.length;x++){
            var regionC = JSON.parse(regionCoordinateDatas[x]);
            if(tszbType == regionC.regionType){
                var param = '&gridCmodelUuid='+newgridCaclMode.GRID_CMODEL_UUID+'&gridUuid='+choosedGrid.GRID_UUID+'&origin='+businessAddress.getPosition()+"&destination="+regionC.coordinate;
                var caclRel = commonObj.postAjax(gridCmodelHanleCertCaclUrl, param);
                return caclRel;
            }
        }
}

/**
 * 最近零售户测距（todo)
 * @param newgridCaclMode
 */
function disCaclLSH(newgridCaclMode){

}

/**
 * 总量、容量测算
 * @param newgridCaclMode
 */
function totalAndVolumeCacl(newgridCaclMode){
    var ruleType = newgridCaclMode.RULE_TYPE;
    if(1 == ruleType || 3 == ruleType){
        var param = '&gridCmodelUuid='+newgridCaclMode.GRID_CMODEL_UUID+'&gridUuid='+choosedGrid.GRID_UUID;
        var caclRel = commonObj.postAjax(gridCmodelHanleCertCaclUrl, param);
        return caclRel;
    }
}


/**
 * 根据某一门店特征加载公式信息
 * @param gridCmNo 特征NO
 * @param gridCaclModelList 已加载的网格模型
 */
function loadNewCmodelListByFeatures (gridCmNo,gridCaclModelList){
    var newCmodelList = [];
    for(var i =0;i<gridCaclModelList.length;i++){
        var gridCaclModel = gridCaclModelList[i];
        var GRID_CMODEL_NO = gridCaclModel.GRID_CMODEL_NO;
        var GRID_CMODEL_NAME = gridCaclModel.GRID_CMODEL_NAME;
        if(GRID_CMODEL_NO == gridCmNo)
            newCmodelList.push(gridCaclModel);
    }
    return newCmodelList;
}

/**
 * 获取某个类型下的所有门店特征
 * @param gridCaclModelList
 */
function loadFeaturesHtmlContent (gridCaclModelList){
    var features = [];
    for(var i =0;i<gridCaclModelList.length;i++){
        var gridCaclModel = gridCaclModelList[i];
        var GRID_CMODEL_NO = gridCaclModel.GRID_CMODEL_NO;
        var GRID_CMODEL_NAME = gridCaclModel.GRID_CMODEL_NAME;
        var isExists = false;
        for(var x =0;x<features.length;x++){
            var feature = features[x];
            if(feature[0] == GRID_CMODEL_NO){
                isExists = true;
                break;
            }
        }
        if(!isExists){
            var temp = [];
            temp[0] = GRID_CMODEL_NO;
            temp[1] = GRID_CMODEL_NAME;
            features.push(temp);
        }
    }

    //门店特征的html展示

    var featuresSelHtml="<select id='featureInp' name='featureInp'>"
    for(var x = 0;x<features.length;x++){
        var feature = features[x];
        featuresSelHtml += "<option value='"+feature[0]+"'>"+feature[1]+"</option>";
    }
    featuresSelHtml+="</select>";
    return featuresSelHtml;
}

/*简单版搜索功能*/
function search(){
    var searchAddress = $("#searchAddress").val();
    AMap.plugin(["AMap.PlaceSearch"], function() {
        //构造地点查询类
        placeSearch = new AMap.PlaceSearch({
            pageSize: 10, // 单页显示结果条数
            pageIndex: 1, // 页码
            city: gdmap_init_info.default_city, // 兴趣点城市
            citylimit: true,  //是否强制限制在设置的城市内搜索
            map: map, // 展现结果的地图实例
            panel: "panel", // 结果列表将在此容器中进行展示。
            autoFitView: true // 是否自动调整地图视野使绘制的 Marker点都处于视口的可见范围
        });
    });
    //增加poi搜索结果坐标点点击、列表点击事件
    placeSearch.on("markerClick",placeSearchMarkerClickFun);
    placeSearch.on("listElementClick",placeSearchMarkerClickFun);

    placeSearch.search(searchAddress);
}

function placeSearchMarkerClickFun(ev){
    console.info(ev);
    var lnglat;
    if("markerClick" == ev.type){
        lnglat = ev.event.lnglat;
    }else if("listElementClick" == ev.type){
        var lng = ev.marker._position.lng;
        var lat = ev.marker._position.lat;
        lnglat = "["+lng+","+lat+"]";
    }
    placeSearch.clear();
    $("#searchAddress").val("");
    dynamicLoadCovers(lnglat);
}

/**
 * 判断当前节点在哪个网格下
 * @param centerCoordinate
 */
function isPointInRing(centerCoordinate){
    var isExists = false;
    for(var i=0;i<gridDatas.length;i++){
        var gridData = gridDatas[i];
        //计算坐标属于哪个网格
        var inRing  = AMap.GeometryUtil.isPointInRing(eval(centerCoordinate),eval("["+gridData.GRID_COORDINATE+"]"));
        if(inRing == true){
            isExists = true;
            choosedGrid = gridData;
            break;
        }
    }
    if(!isExists)
        choosedGrid='';
}