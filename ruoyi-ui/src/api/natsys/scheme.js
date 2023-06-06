import request from '@/utils/request'

// 查询检测方案列表
export function listScheme(query) {
  return request({
    url: '/natsys/scheme/list',
    method: 'get',
    params: query
  })
}

// 查询检测方案详细
export function getScheme(schemeId) {
  return request({
    url: '/natsys/scheme/' + schemeId,
    method: 'get'
  })
}

// 新增检测方案
export function addScheme(data) {
  return request({
    url: '/natsys/scheme',
    method: 'post',
    data: data
  })
}

// 修改检测方案
export function updateScheme(data) {
  return request({
    url: '/natsys/scheme',
    method: 'put',
    data: data
  })
}

// 删除检测方案
export function delScheme(schemeId) {
  return request({
    url: '/natsys/scheme/' + schemeId,
    method: 'delete'
  })
}
