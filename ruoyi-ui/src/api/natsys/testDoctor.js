import request from '@/utils/request'

// 查询检测记录列表
export function listTestDoctor(query) {
  return request({
    url: '/natsys/testDoctor/list',
    method: 'get',
    params: query
  })
}

// 查询检测记录详细
export function getTestDoctor(testId) {
  return request({
    url: '/natsys/testDoctor/' + testId,
    method: 'get'
  })
}

// 新增检测记录
export function addTestDoctor(data) {
  return request({
    url: '/natsys/testDoctor',
    method: 'post',
    data: data
  })
}

// 修改检测记录
export function updateTestDoctor(data) {
  return request({
    url: '/natsys/testDoctor',
    method: 'put',
    data: data
  })
}

// 删除检测记录
export function delTestDoctor(testId) {
  return request({
    url: '/natsys/testDoctor/' + testId,
    method: 'delete'
  })
}
