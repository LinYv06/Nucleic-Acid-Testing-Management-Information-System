import request from '@/utils/request'

// 查询检测结果列表
export function listTestPatient(query) {
  return request({
    url: '/natsys/testPatient/list',
    method: 'get',
    params: query
  })
}

// 查询检测结果详细
export function getTestPatient(testId) {
  return request({
    url: '/natsys/testPatient/' + testId,
    method: 'get'
  })
}

// 新增检测结果
export function addTestPatient(data) {
  return request({
    url: '/natsys/testPatient',
    method: 'post',
    data: data
  })
}

// 修改检测结果
export function updateTestPatient(data) {
  return request({
    url: '/natsys/testPatient',
    method: 'put',
    data: data
  })
}

// 删除检测结果
export function delTestPatient(testId) {
  return request({
    url: '/natsys/testPatient/' + testId,
    method: 'delete'
  })
}
