       <A HREF="http://java.sun.com/j2se/1.5.0/docs/api/java/util/Map.html?is-external=true" title="class or interface in java.util">Map</A>&nbsp;data,
                               <A HREF="http://java.sun.com/j2se/1.5.0/docs/api/java/lang/Object.html?is-external=true" title="class or interface in java.lang">Object</A>&nbsp;primaryKey,
                               <A HREF="../../../../../org/hibernate/envers/reader/AuditReaderImplementor.html" title="interface in org.hibernate.envers.reader">AuditReaderImplementor</A>&nbsp;versionsReader,
                               <A HREF="http://java.sun.com/j2se/1.5.0/docs/api/java/lang/Number.html?is-external=true" title="class or interface in java.lang">Number</A>&nbsp;revision)</PRE>
<DL>
<DD><B>Description copied from interface: <CODE><A HREF="../../../../../org/hibernate/envers/entities/mapper/PropertyMapper.html#mapToEntityFromMap(org.hibernate.envers.configuration.AuditConfiguration, java.lang.Object, java.util.Map, java.lang.Object, org.hibernate.envers.reader.AuditReaderImplementor, java.lang.Number)">PropertyMapper</A></CODE></B></DD>
<DD>Maps properties from the given map to the given object.
<P>
<DD><DL>
<DT><B>Specified by:</B><DD><CODE><A HREF="../../../../../org/hibernate/envers/entities/mapper/PropertyMapper.html#mapToEntityFromMap(org.hibernate.envers.configuration.AuditConfiguration, java.lang.Object, java.util.Map, java.lang.Object, org.hibernate.envers.reader.AuditReaderImplementor, java.lang.Number)">mapToEntityFromMap</A></CODE> in interface <CODE><A HREF="../../../../../org/hibernate/envers/entities/mapper/PropertyMapper.html" title="interface in org.hibernate.envers.entities.mapper">PropertyMapper</A></CODE></DL>
</DD>
<DD><DL>
<DT><B>Parameters:</B><DD><CODE>verCfg</CODE> - Versions configuration.<DD><CODE>obj</CODE> - Object to map to.<DD><CODE>data</CODE> - Data to map from.<DD><CODE>primaryKey</CODE> - Primary key of the object to which we map (for relations)<DD><CODE>versionsReader</CODE> - VersionsReader for reading relations<DD><CODE>revision</CODE> - Revision at which the object is read, for reading relations</DL>
</