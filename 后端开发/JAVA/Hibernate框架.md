# Hibernate框架
## Hibernate缓存机制
<p>N+1问题：</p>
<p>使用hql查询表时，list()只会发出一条sql语句，而iterator()会发出N+1条，一条查询表中所有id，然后遍历id一条一条读取</p>
<p>一级缓存(session):</p>
<p>使用session缓存查询的对象，但是如果session关闭，hibernate会重新发送sql查询</p>
```
session = HibernateUtil.openSession();
```
<p>二级缓存(sessionFactory):</p>
<p>二级缓存需要加入额外的缓存包，如EHcache、Redis等，并在hibernate.xml中配置</p>
```
<hibernate-mapping package="com.xxx.bean">
    <class name="example" table="example">
        <!-- 二级缓存一般设置为只读的 -->
        <cache usage="read-only"/>
        <id name="id" type="int" column="id">
            <generator class="native"/>
        </id>
        <property name="name" column="name" type="string"></property>
        <many-to-one name="test" column="test" fetch="join"></many-to-one>
    </class>
</hibernate-mapping>
```
<p>注意：二级缓存只缓存对象，如果取出的只是一些属性值，那就无法加入缓存</p>
<p>查询缓存:</p>
<p>用于缓存hql语句，在编写hql时，设置一个参数：</p>
```
session.createQuery("from example where name like ?").setCacheable(true)
```
