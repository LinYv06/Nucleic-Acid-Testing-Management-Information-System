import request from '@/utils/request'

// 查询管理数据列表
export function listAnalysis(query) {
  return request({
    url: '/natsys/analysis/list',
    method: 'get',
    params: query
  })
}

// 查询管理数据详细
export function getAnalysis(analysisId) {
  return request({
    url: '/natsys/analysis/' + analysisId,
    method: 'get'
  })
}

// 新增管理数据
export function addAnalysis(data) {
  return request({
    url: '/natsys/analysis',
    method: 'post',
    data: data
  })
}

// 修改管理数据
export function updateAnalysis(data) {
  return request({
    url: '/natsys/analysis',
    method: 'put',
    data: data
  })
}

// 删除管理数据
export function delAnalysis(analysisId) {
  return request({
    url: '/natsys/analysis/' + analysisId,
    method: 'delete'
  })
}
