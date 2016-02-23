# XML Level File Template #

This probably won't be final yet, but it's just a rough template for a level file. If I forgot anything let me know.

```
<?xml version = "1.0" encoding = "utf-8"?>

<!-- Luminance Game Level Template -->
<!-- Designed by Steven Indzeoski -->
<!-- University of Saskatchewan CMPT 371 -->

<level>
	<!-- Level Information -->
	<name>Level 1</name>
	<difficulty>easy</difficulty>
	<grid_size>
		<x>10</x>
		<y>10</y>
		<width>1.0</width>
		<height>1.0</height>
	</grid_size>
	
	<!-- Level Objects -->
	<object>
		<type>brick</type>
		<position>
			<x>2</x>
			<y>2</y>
		</position>
		<rotation>
			<x>0</x>
			<y>0</y>
			<z>0</z>
		</rotation>
	</object>
	<object>
		<type>goal</type>
		<colour>red</colour>
		<position>
			<x>5</x>
			<y>1</y>
		</position>
		<rotation>
			<x>0</x>
			<y>0</y>
			<z>0</z>
		</rotation>
	</object>
	<object>
		<type>emitter</type>
		<colour>red</colour>
		<position>
			<x>0</x>
			<y>0</y>
		</position>
		<rotation>
			<x>0</x>
			<y>90</y>
			<z>90</z>
		</rotation>
	</object>
	
	<!-- Level Tools -->
	<tool>
		<type>mirror</type>
		<count>5</count>
	</tool>
	<tool>
		<type>prism</type>
		<count>1</count>
	</tool>
</level>
```