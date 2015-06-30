# LightListview

Clean ListView Code, now no longer need the adapter

A year ago , [objc.io](http://objc.io) write a [article](http://www.objc.io/issues/1-view-controllers/table-views/) about clean tableview. I think it is cool and use they method in android. Now I want share you. ListView are an extremely versatile building block for android apps. Therefore, a lot of code is directly or indirectly related to listview tasks, including supplying data, updating the listview, controlling its behavior, and reacting to selections, to name just a few. In this project, I have present techniques to keep your code clean and well-structured.

#How to use


And first you should add `BaseCellHolder.java` and `QBaseAdapter.java` to your project.

now,you can init adapter like this, and then set adapter to listview.`R.layout.cell_demo` is the view of listview items.You can do every thing in `CellHolder` instread of BaseAdapter's getView method.

```
		adapter = new QBaseAdapter<DemoModel>(getActivity(), null,
				R.layout.cell_demo, new CreateHolderListener() {

					@Override
					public BaseCellHolder cellHolder(View cellView) {
						// TODO Auto-generated method stub
						return new DemoCellHolder(cellView);
					}
				});
		listView.setAdapter(adapter);

```
