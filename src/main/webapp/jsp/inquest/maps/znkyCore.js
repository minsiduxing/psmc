/**
 * 测距(中小学&&幼儿园)
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
 * 测距(最近零售户)
 * @param newgridCaclMode
 */
function disCaclLSH(newgridCaclMode){
    var ruleType = newgridCaclMode.RULE_TYPE;
    for(var x=0;x<licDatas.length;x++){
        var licData = JSON.parse(licDatas[x]);
        var param = '&gridCmodelUuid='+newgridCaclMode.GRID_CMODEL_UUID+'&gridUuid='+choosedGrid.GRID_UUID+'&origin='+businessAddress.getPosition()+"&destination="+licData.coordinate;
        var caclRel = commonObj.postAjax(gridCmodelHanleCertCaclUrl, param);
        return caclRel;
    }
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
function loadNewCmodelListBygridCmNo (gridCmNo,gridCaclModelList){
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
function loadFeatures (gridCaclModelList){
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
    return features;
}

function loadFeaturesHtmlContent (features){
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

/**
 * 最近零售户撒点展示
 * 测算原点到所有能加载到的零售户的地面距离 并进行判断，符合条件的展示
 * @param centerCoordinate
 */
function lshCoverView(centerCoordinate){
    for (var i = 0; i < licDatas.length; i++) {
        var licData = licDatas[i];
        if(typeof(licData) != 'object'){
            licData = JSON.parse(licData);
        }
        //计算坐标点和网格的地面距离
        var dis = AMap.GeometryUtil.distance(eval(centerCoordinate),eval("["+licData.coordinate+"]"));
        licData.DIS = dis;
        licDatas[i] = JSON.stringify(licData);
        /*展示原点<=x米范围内覆盖物*/
        if(parseInt(dis)<=gdmap_cacl_param.origin_to_grid_dis){
            var marker = new AMap.Marker({
                position: eval("["+licData.coordinate+"]"),
                title: licData.managerName+"["+licData.licNo+"]"
                // icon:gdmap_icon.default_lsh
            });
            coverGroups.push(marker);
        }
    }
}


/**
 * 最近区域（中小学、幼儿园）的撒点展示
 * 测算原点到所有能加载到的中小学、幼儿园的地面距离 并进行判断，符合条件的展示
 * @param centerCoordinate
 */
function regionCoverView(centerCoordinate){
    for (var i = 0; i < regionCoordinateDatas.length; i++) {
        var regioncData = JSON.parse(regionCoordinateDatas[i]);
        //计算坐标点和网格的地面距离
        var dis = AMap.GeometryUtil.distance(eval(centerCoordinate),eval("["+regioncData.coordinate+"]"));
        regioncData.DIS = dis;
        regionCoordinateDatas[i] = JSON.stringify(regioncData);
        /*展示原点<=x米范围内覆盖物*/
        if(parseInt(dis)<=gdmap_cacl_param.origin_to_grid_dis){
            var marker = new AMap.Marker({
                position: eval("["+regioncData.coordinate+"]"),
                title: regioncData.regionName
            });
            coverGroups.push(marker);
        }
    }
}

/**
 * 最近网格的撒点展示
 * 测算原点到所有能加载到的网格的地面距离 并进行判断，符合条件的展示
 * @param centerCoordinate
 */
function gridCoverView(centerCoordinate){
    for (var i = 0; i < gridDatas.length; i++) {
        var gridData = eval(gridDatas[i]);
        //计算坐标点和网格的地面距离
        var dis = AMap.GeometryUtil.distanceToSegment(eval(centerCoordinate),eval("["+gridData.GRID_COORDINATE+"]"));
        gridData.DIS = dis;
        gridDatas[i] = gridData;
        if(parseInt(dis)<=gdmap_cacl_param.origin_to_grid_dis){
            var polygon = new AMap.Polygon({
                path: eval("["+gridData.GRID_COORDINATE+"]"),
                extData:gridData
            });
            polygon.setOptions(JSON.parse(gridData.MAP_STYLE));
            polygon.on('click', polygonClickFunc);
            coverGroups.push(polygon);
        }
    }
}


function caclAndView(gridCmNo,gridCaclModelList){
    debugger;
    var zlcsResult = true;
    var allResult = true;
    gridCmNo = $("#featureInp").val();
    var newgridCaclModelList = loadNewCmodelListBygridCmNo(gridCmNo,gridCaclModelList);
    //分别执行公式进行测算
    var rresult = "";
    for(var z=0;z<newgridCaclModelList.length;z++){
        var rdata = null;
        var newgridCaclMode = newgridCaclModelList[z];
        var ruleType = newgridCaclMode.RULE_TYPE;
        if(4 == ruleType || 5 == ruleType){
            rdata = disCacl(newgridCaclMode);
        }
        if(2 == ruleType ){
            rdata = disCaclLSH(newgridCaclMode);
        }
        if(1 == ruleType){
            rdata = totalAndVolumeCacl(newgridCaclMode);
        }
        if(3 == ruleType){
            rdata = totalAndVolumeCacl(newgridCaclMode);
        }
        if(rdata !=null){
            rdata = JSON.parse(rdata);
            console.info(rdata);
            if(rdata.result.flag != 1 && 1 == ruleType){
                zlcsResult = false;
            }
            if(rdata.result.flag != 1 && 1 != ruleType){
                allResult = false;
            }
            rresult +="</br>"+rdata.result.msg;
        }
    }
    if(!allResult){
        rresult += "</br><h3>系统测算您当前所选的经营地址不符合办证条件!</h3>";
    }else{
        if(!zlcsResult)
            rresult += "</br><h3>系统测算您当前所选的经营地址总体符合办证条件,但由于经营地址所在网格容量已满无办证指标,您可向当地烟草专卖局申请排队办理。待网格内有余量时工作人员会及时通知您进行办理!</h3>";
        else
            rresult +="</br><h3>系统测算您当前所选的经营地址总体符合办证条件,您可进行烟草零售许可证申请!</h3>";
    }
    $('#calceResultViewDiv').window({
        title:"测算结果",
        width:750,
        height:250,
        modal:true,
        content:rresult,
        minimizable:false,
        maximizable:false,
        closable:true,
        collapsible:false
    });
}