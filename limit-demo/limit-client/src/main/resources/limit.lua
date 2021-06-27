-- 利用redis里面incr是个原子递增操作
-- lua 脚本可以传递参数，参数有两个固定属性：KEYS / ARGV
-- KEYS[1]: 资源，比如此处的 手机号
-- ARGV[1]: 比如此处的 超时时间
-- ARGV[2]:

-- 访问一次，自增1
local times = redis.call('incr', KEYS[1])

-- 第一次访问，顺便设置keys的超时时间
if times == 1 then
    redis.call('expire', KEYS[1], ARGV[1])
end

-- 第二次访问，
if times > tonumber(ARGV[2]) then
    return 0
end

return 1