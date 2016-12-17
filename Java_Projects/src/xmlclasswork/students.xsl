<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="html" />
	<xsl:template match="/">
		<html>
			<body>
				<h2>Students</h2>
				<table border="1">
					<tr bgcolor="#9acd32">
						<th>Last Name</th>
						<th>Age</th>
					</tr>
					<xsl:for-each select="studentList/student">
						<tr>
							<td>
								<xsl:value-of select="lastName" />
							</td>
							<td>
								<xsl:value-of select="age" />
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>