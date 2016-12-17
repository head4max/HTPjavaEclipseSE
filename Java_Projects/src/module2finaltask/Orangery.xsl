<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="html" />
	<xsl:template match="/">
		<html>
			<body>
				<h2>Orangery</h2>
				<table border="1">
					<tr bgcolor="#9acd32">
						<th>Name</th>
						<th>Soil</th>
						<th>VisualParametr</th>
						<th>Origin</th>
						<th>GrowingTips</th>
						<th>Multiplying</th>
					</tr>
					<xsl:for-each select="Orangery/plant">
					<xsl:sort order="ascending" select="number(growingTips/temperature)" data-type="number"/>
						<tr>
							<td>
								<xsl:value-of select="name" />
							</td>
							<td>
								<xsl:value-of select="soil" />
							</td>
							<td>
								<xsl:value-of select="visualParametr/@color" />
								;
								<xsl:value-of select="visualParametr/@range" />
							</td>
							<td>
								<xsl:value-of select="origin" />
							</td>
							<td>
								<xsl:value-of select="growingTips/temperature" />
								<xsl:value-of select="growingTips/temperature/@ei" />
								;
								<xsl:value-of select="growingTips/watering" />
								<xsl:value-of select="growingTips/watering/@ei" />
							</td>
							<td>
								<xsl:value-of select="multiplying" />
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>