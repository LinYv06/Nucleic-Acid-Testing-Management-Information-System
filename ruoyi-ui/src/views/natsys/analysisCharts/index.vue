<template>
  <div class="app-container">
    <div class="info">
      <p class="title">
        <i></i>
          病毒信息
      </p>
      <div class="content">
        <p>易感人群：人群普遍易感，老年人及有基础疾病者感染后病情较重，儿童及婴幼儿也有发病</p>
        <p>潜伏期：一般为3~7天，最长不超过14天，潜伏期内可能存在传染性，其中无症状病例传染性非常罕见</p>
        <p>宿主：野生动物，可能为中华菊头蝠</p>
        <p>病毒：SARS-CoV-2,其导致疾病命名COVID-19</p>
        <p>传染源：新冠肺炎的患者。无症状感染者也可能成为传染源。</p>
        <p>传播途径：经呼吸道飞沫、接触传播是主要的传播途径。气溶胶传播和消化道等传播途径尚待明确。</p>
      </div>
    </div>

    <div class="case-num">
      <div class="container">
        <div class="title">
          <span>截至 {{ nowTime }} 全国数据统计</span>
        </div>
      </div>
      <div class="num">
        <ul class="count">
          <li>
            <div class="create-item">
              <div class="create-count">
                <b>
                  较昨日
                  <em style="color:rgb(247,76,49)">+23</em>
                </b>
              </div>
              <strong style="color:rgb(247,76,49)">621</strong>
              <span>现存确诊</span>
            </div>
          </li>
          <!-- <li>
            <div class="create-item">
              <div class="create-count">
                <b>
                  较昨日
                  <em style="color:rgb(247,130,7)">{{  }}</em>
                </b>
              </div>
              <strong style="color:rgb(247,130,7)">{{  }}</strong>
              <span>现存疑似</span>
            </div>
          </li> -->
          <!-- <li>
            <div class="create-item">
              <div class="create-count">
                <b>
                  较昨日
                  <em style="color:rgb(162,90,78)">{{  }}</em>
                </b>
              </div>
              <strong style="color:rgb(162,90,78)">{{  }}</strong>
              <span>现存重症</span>
            </div>
          </li> -->
          <li>
            <div class="create-item">
              <div class="create-count">
                <b>
                  较昨日
                  <em style="color:rgb(174, 33, 44)">+23</em>
                </b>
              </div>
              <strong style="color:rgb(174, 33, 44)">85697</strong>
              <span>累计确诊</span>
            </div>
          </li>
          <!-- <li>
            <div class="create-item">
              <div class="create-count">
                <b>
                  较昨日
                  <em style="color:rgb(93, 112, 146)">{{  }}</em>
                </b>
              </div>
              <strong style="color:rgb(93, 112, 146)">{{  }}</strong>
              <span>累计死亡</span>
            </div>
          </li> -->
          <li>
            <div class="create-item">
              <div class="create-count">
                <b>
                  较昨日
                  <em style="color:rgb(40, 183, 163)">+37</em>
                </b>
              </div>
              <strong style="color:rgb(40, 183, 163)">80445</strong>
              <span>累计治愈</span>
            </div>
          </li>
        </ul>
      </div>
    </div>

    <p class="title">
      <i></i> 疫情地图
    </p>
    <div id="chinaMap"></div>
    
    <!-- <div class="chart">
      <h3 class="title">全国</h3>
      <swiper ref="mySwiper" :options="swiperOption">
        <swiper-slide v-for="(slide,index) in quanguoTrendChart" :key="index">
          <img :src="slide.imgUrl" alt="">
        </swiper-slide>
        <div class="swiper-pagination" slot="pagination"></div>
      </swiper>
      <ul class="navigator">
        <li
          @click="changePage(index)"
          :class="{ active:index === currentIndex }"
          class="navigatorItem"
          v-for="(item,index) in quanguoTrendChart"
          :key="index"
        >{{ item.title }}</li>
      </ul>
    </div> -->
  </div>
</template>

<script>
import "../../../assets/css/common.css"

export default {
  name: "AnalysisCharts",
  created() {
    this.currentTime()
  },
  data() {
    return {
      nowTime:'',
      cityMapData: [
        {
          name: '北京',
          value: 212
        }, {
          name: '天津',
          value: 60
        }, {
          name: '上海',
          value: 208
        }, {
          name: '重庆',
          value: 337
        }, {
          name: '河北',
          value: 126
        }, {
          name: '河南',
          value: 675
        }, {
          name: '云南',
          value: 117
        }, {
          name: '辽宁',
          value: 74
        }, {
          name: '黑龙江',
          value: 155
        }, {
          name: '湖南',
          value: 593
        }, {
          name: '安徽',
          value: 480
        }, {
          name: '山东',
          value: 270
        }, {
          name: '新疆',
          value: 2
        }, {
          name: '江苏',
          value: 308
        }, {
          name: '浙江',
          value: 829
        }, {
          name: '江西',
          value: 476
        }, {
          name: '湖北',
          value: 135
        }, {
          name: '广西',
          value: 139
        }, {
          name: '甘肃',
          value: 55
        }, {
          name: '山西',
          value: 74
        }, {
          name: '内蒙古',
          value: 34
        }, {
          name: '陕西',
          value: 142
        }, {
          name: '吉林',
          value: 42
        }, {
          name: '福建',
          value: 179
        }, {
          name: '贵州',
          value: 56
        }, {
          name: '广东',
          value: 797
        }, {
          name: '青海',
          value: 0
        }, {
          name: '西藏',
          value: 0
        }, {
          name: '四川',
          value: 282
        }, {
          name: '宁夏',
          value: 34
        }, {
          name: '海南',
          value: 79
        }, {
          name: '台湾',
          value: 10
        }, {
          name: '香港',
          value: 15
        }, {
          name: '澳门',
          value: 9
        }
      ]
    };
  },

  mounted() {
    this.cityMapData.forEach( item => {
        item.itemStyle = {
          normal: {
            areaColor: this.setColor(
              item.value
            )
          }
        }
    });
    this.$charts.chinaMap("chinaMap", this.cityMapData);
  },

  methods: {
    getDate() {
      let date = new Date();
      let year = date.getFullYear(); // 年
      let month = date.getMonth() + 1; // 月
      let day = date.getDate(); // 日
      let week = date.getDay(); // 星期
      let weekArr = [ "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" ];
      let hour = date.getHours(); // 时
      hour = hour < 10 ? "0" + hour : hour; // 如果只有一位，则前面补零
      let minute = date.getMinutes(); // 分
      minute = minute < 10 ? "0" + minute : minute; // 如果只有一位，则前面补零
      let second = date.getSeconds(); // 秒
      second = second < 10 ? "0" + second : second; // 如果只有一位，则前面补零
      this.nowTime = `${year}年${month}月${day}日 ${weekArr[week]}`;
      // this.nowTime = `${year}年${month}月${day}日 ${hour}时${minute}分${second}秒 ${weekArr[week]}`;
    },
       
    //定时器调取当前时间
    currentTime(){
      setInterval(()=>{
        this.getDate()
      },1000)
    },

    setColor(value) {
      let currentColor = "";
      switch (true) {
        case value == 0:
          currentColor = "#fff";
          break;
        case value > 0 && value < 10:
          currentColor = "#FDFDCF";
          break;
        case value >= 10 && value < 100:
          currentColor = "#FE9E83";
          break;
        case value >= 100 && value < 500:
          currentColor = "#E55A4E";
          break;
        case value >= 500 && value < 10000:
          currentColor = "#4F070D";
          break;
      }
      return currentColor;
    }
  }
};
</script>

<style scoped>
.info{
    padding: 0.16rem;
    background: #fff;
    border-bottom: 1px solid #f1f1f1;
}
.title{
    font-size: 0.17rem;
}

.title i{
    display: inline-block;
    width: 0.04rem;
    height: 0.16rem;
    margin-right: 0.03rem;
    vertical-align: middle;
    background: #4169e2;
}
.content{
    padding: 0.06rem 0.16rem;
}

.content p{
    font-size: 13px;
    margin: 5px 0;
}


.case-num {
    padding: 0.16rem;
    background: #fff;
}
.container {
    margin: -0.16rem 0 0;
    font-size: 0.12rem;
}
.title {
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0.08rem 0 0.07rem;
    line-height: 0.24rem;
}
.title span {
    color: #666;
}
.title em {
    display: flex;
    align-items: center;
    justify-content: space-between;
    height: 0.24rem;
    margin-right: -0.16rem;
    padding: 0 0.08rem;
    color: #666;
    font-style: normal;
    background-color: #f7f7f7;
    border-radius: 0.12rem 0 0 0.12rem;
}
.title em img {
    width: 0.123rem;
    height: 0.123rem;
    margin-right: 0.037rem;
}
.num {
    position: relative;
    text-align: center;
    background: #fff;
}
.num::after {
    position: absolute;
    top: -0.01rem;
    left: -0.01rem;
    display: block;
    width: 200%;
    height: 200%;
    border: 0.01rem solid #ebebeb;
    border-radius: 0.08rem;
    box-shadow: 0 0.04rem 0.12rem 0 rgba(0, 0, 0, 0.05);
    transform: scale(0.5);
    transform-origin: 0 0;
    content: "";
}
.num ul {
    flex-flow: wrap;
    position: relative;
    display: flex;
    margin: 0;
    padding: 0.08rem 0 0.12rem;
}
.num ul li {
    position: relative;
    z-index: 1;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    box-sizing: border-box;
    width: 33.3333333%;
    margin: 10px 0;
}
.num ul li .create-item {
    position: relative;
    text-align: center;
}
.num ul li .create-item .create-count {
    display: flex;
    align-items: center;
    height: 0.12rem;
    margin-bottom: 0.02rem;
    color: #666;
    font-weight: 400;
    font-size: 0.09rem;
}
.num ul li .create-item .create-count em {
    font-weight: 400;
    font-style: normal;
}
.num ul li strong {
    margin-bottom: 0.01rem;
    font-weight: 700;
    font-size: 0.2rem;
    line-height: 0.25rem;
}
.num ul li span {
    display: block;
    color: #333;
    font-weight: 700;
    font-size: 0.11rem;
    line-height: 0.15rem;
}


#chinaMap {
    width: 100%;
    height: 1000px;
}
.title {
    border-top: 0.005rem solid #ebebeb;
    border-bottom: 0;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
    -webkit-box-pack: start;
    -ms-flex-pack: start;
    justify-content: flex-start;
    height: 0.44rem;
    padding: 0 0.16rem;
    font-weight: 500;
    font-size: 0.17rem;
    line-height: 0.44rem;
    background: #fff;
}
.title::before{
    content:"";
    width: 5px;
    height: 20px;
    background: #4169e2;
    margin-right: 10px;
}


.line{
    width: 100%;
    height: 300px;
}
.chart {
    position: relative;
    background: #fff;
    padding: 0.16rem 0;
}
.chart .title {
    font-size: 0.16rem;
    margin: 0 0 0.08rem 0.16rem;
}
.chart .swiper-pagination {
    position: absolute;
    text-align: center;
    -webkit-transition: 300ms opacity;
    -o-transition: 300ms opacity;
    transition: 300ms opacity;
    -webkit-transform: translate3d(0, 0, 0);
    transform: translate3d(0, 0, 0);
    z-index: 10;
}
.chart .swiper-pagination-bullet {
    width: calc(20% - 0.02rem);
    text-align: center;
    background: #f7f7f7;
    padding: 0.045rem;
    box-sizing: border-box;
    color: #666;
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 0.02rem;
}
.navigator {
    font-size: 0.12rem;
    list-style: none;
    display: flex;
    padding: 0 0.16rem;
    justify-content: center;
    margin: 0.06rem 0 0;
}
.navigatorItem {
    color: #4169e2;
    background: #f1f5ff;
    position: relative;
    width: calc(20% - 0.02rem);
    text-align: center;
    background: #f7f7f7;
    padding: 0.045rem;
    box-sizing: border-box;
    color: #666;
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 0.02rem;
    margin-left: 0.025rem;
}
.active {
    color: #4169e2;
    background: #f1f5ff;
    position: relative;
}
</style>