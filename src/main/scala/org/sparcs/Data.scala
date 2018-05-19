package org.sparcs

object Data {
  def readFile(name: String): Option[String] = jsons.get(name)

  private val jsons: Map[String, String] = Map(
"buses" -> """olev
wp
munji
munjilaunch
munjiweekend
munjihwaam
munjihwaamweekend""",
"olev" -> """{
    "name": "올레브",
    "day": [0, 1, 2, 3, 4], 
    "errtime": true,
    "errday": true,
    "times": [[8,45], [8,55], [9,15], [9,25], [9,45], [9,55], [10,15], [10,25], [10,45], [10,55], [11,15], [11,25], [11,45], [12,55], [13,15], [13,25], [13,45], [13,55], [14,15], [14,25], [14,45], [14,55], [15,15], [15,25], [15,45], [15,55], [16,15], [16,25], [16,45], [16,55]],
    "keys": ["olev", "올레브", "올래브", "전기", "캠퍼스"], 
    "stops": [
        {"time": {"arrival": 14, "departure": 0}, "name": "학사식당", "keys": ["카마", "카이마루", "출발", "종점", "북측", "학식", "식당", "학사"]},
        {"time": {"arrival": 1}, "name": "스포츠컴플렉스", "keys": ["스컴", "스포츠", "컴플", "체육"]},
        {"time": {"arrival": 3}, "name": "창의학습관", "keys": ["창의", "e11", "학습"]},
        {"time": {"arrival": 4}, "name": "의과학연구센터", "keys": ["의과학", "의학"]},
        {"time": {"arrival": 6}, "name": "카이스트클리닉", "keys": ["클리닉", "파팔", "운동장", "병원"]},
        {"time": {"arrival": 9}, "name": "정문", "keys": ["정문", "입구"]},
        {"time": {"arrival": 10}, "name": "오리연못", "keys": ["오리", "연못"]},
        {"time": {"arrival": 11}, "name": "본관", "keys": ["지원", "w8", "본관"]} 
    ]   
}""",
"wp" -> """{
    "name": "월평 셔틀",
    "day": [0, 1, 2, 3, 4], 
    "errtime": true,
    "errday": true,
    "times": [[9, 5], [10, 5], [11, 5], [13, 5], [14, 5], [15, 5], [16, 5], [17, 5]],
    "keys": ["월평", "시내"], 
    "stops": [
        {"time": {"arrival": 40, "departure": 0}, "name": "대강당", "keys": ["강당"]},
        {"time": {"arrival": 39, "departure": 2}, "name": "본관", "keys": ["본관"]},
        {"time": {"arrival": 38, "departure": 4}, "name": "오리연못", "keys": ["오리", "연못"]},
        {"time": {"arrival": 10}, "name": "충남대학교", "keys": ["충"]},
        {"time": {"arrival": 15}, "name": "월평역(시내방향)", "keys": ["역"]},
        {"time": {"arrival": 20}, "name": "갤러리아", "keys": ["갤", "겔", "타임", "월드", "둔산"]},
        {"time": {"arrival": 27}, "name": "정부청사", "keys": ["정부", "청사", "터미널", "시외"]},
        {"time": {"arrival": 35}, "name": "월평역(학교방향)", "keys": ["역"]} 
    ]   
}""",
"munji" -> """{
    "name": "본원-문지 셔틀",
    "day": [0, 1, 2, 3, 4],
    "errtime": true,
    "errday": false,
    "times": [[0, 40], [1, 40], [2, 40], [7, 30], [8, 0], [8, 30], [9, 0], [9, 40], [10, 10], [10, 40], [11, 10], [13, 40], [14, 40], [15, 40], [16, 40], [17, 10], [17, 40], [18, 10], [18, 40], [19, 10], [19,  40], [20, 40], [21, 10], [21, 40], [22, 40], [23, 40]],
    "keys": ["문지"],
    "stops": [
        {"time": {"arrival": 40, "departure": 0}, "name": "문지", "keys": ["문지"]},
        {"time": {"arrival": 4}, "name": "로덴하우스 앞", "keys": ["로덴"]},
        {"time": {"arrival": 20, "departure": 20}, "name": "본원", "keys": ["본", "오리", "연못", "강당"]},
        {"time": {"arrival": 35}, "name": "교수아파트 앞", "keys": ["교수", "아파트"]}
    ]
}""", 
"munjilaunch" -> """{
    "name": "본원-문지 점심셔틀",
    "day": [0, 1, 2, 3, 4],
    "errtime": false,
    "errday": false,
    "times": [[12, 10]],
    "keys": ["문지"],
    "stops": [
        {"time": {"arrival": 70, "departure": 0}, "name": "문지", "keys": ["문지"]},
        {"time": {"arrival": 4}, "name": "로덴하우스 앞", "keys": ["로덴"]},
        {"time": {"arrival": 20, "departure": 50}, "name": "본원", "keys": ["본", "오리", "연못", "강당"]},
        {"time": {"arrival": 65}, "name": "교수아파트 앞", "keys": ["교수", "아파트"]}
    ]
}""",
"munjiweekend" -> """{
    "name": "본원-문지 셔틀",
    "day": [5, 6],
    "errtime": true,
    "errday": false,
    "times": [[0, 40], [2, 10], [8, 10], [9, 40], [11, 10], [12, 40], [14, 10], [15, 40], [17, 10], [18, 40], [20, 10], [21, 40], [23, 10]],
    "keys": ["문지"],
    "stops": [
        {"time": {"arrival": 40, "departure": 0}, "name": "문지", "keys": ["문지"]},
        {"time": {"arrival": 4}, "name": "로덴하우스 앞", "keys": ["로덴"]},
        {"time": {"arrival": 20, "departure": 20}, "name": "본원", "keys": ["본", "오리", "연못", "강당"]},
        {"time": {"arrival": 35}, "name": "교수아파트 앞", "keys": ["교수", "아파트"]}
    ]
}""",
"munjihwaam" -> """{
    "name": "문지-화암 셔틀",
    "day": [0, 1, 2, 3, 4],
    "errtime": true,
    "errday": false,
    "times": [[0, 20], [1, 20], [2, 20], [3, 20], [7, 10], [7, 40], [8, 10], [8, 40], [9, 20], [9, 50], [10, 20], [10, 50], [11, 20], [11, 50], [13, 20], [14, 20], [15, 20], [16, 20], [16, 50], [17, 20], [17,  50], [18, 20], [18, 50], [19, 20], [19, 50], [20, 20], [21, 20], [21, 50], [22, 20], [23, 20]],
    "keys": ["문지", "화암"],
    "stops": [
        {"time": {"arrival": 20, "departure": 0}, "name": "문지", "keys": ["문지"]},
        {"time": {"arrival": 10, "departure": 10}, "name": "화암", "keys": ["화암"]}
    ]
}""",
"munjihwaamweekend" -> """{
    "name": "문지-화암 셔틀",
    "day": [5, 6],
    "errtime": true,
    "errday": false,
    "times": [[0, 20], [1, 50], [7, 50], [9, 20], [10, 50], [12, 20], [13, 50], [15, 20], [16, 50], [18, 20], [19, 50], [21, 20], [22, 50]],
    "keys": ["문지", "화암"],
    "stops": [
        {"time": {"arrival": 20, "departure": 0}, "name": "문지", "keys": ["문지"]},
        {"time": {"arrival": 10, "departure": 10}, "name": "화암", "keys": ["화암"]}
    ]
}"""
  )
}
